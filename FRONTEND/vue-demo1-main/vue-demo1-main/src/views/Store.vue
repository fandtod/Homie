<template>
    <div>
        <aside class=" aside">
        <nav class="nav">
            <button type="button" class="btn_hamburger">按鈕</button>
        </nav>
        <div class="serachin">
           
          <div class="boxProduct">
                <span>商品名稱</span>
                <input @keyup.enter="search" placeholder="" v-model="searchText" class="new-todo" />
          </div>
          <div class="boxProduct">
                <span>價格</span>
                <input type="number" oninput="if(value<0)value=0" @keyup.enter="search" id="price1" placeholder="" v-model="searchPrice1" class="new-todo" />
                <span class="it">~</span>
                <input type="number" oninput="if(value<0)value=0" @keyup.enter="search" id="price2" placeholder="" v-model="searchPrice2" class="new-todo" />
          </div>
           
        </div>
        <button class="searchitem" @click="search" @keyup.enter="search">查詢</button>
    </aside>

    <main class="main">
        <div class="search">
            <!-- <div class="slider" v-for="(item,index) in data" :key="item.advertiseId">
              <div class="slider-content">
                <div class="slider-wrapper">
                    <img class="sliderimg" :src="imgUrl(item.advertisePictureName)" alt="" />
                
              </div>  
                <div class="slider-footer">
                    <p>這是房子</p>
                    <ul class="slider-indicator">
                        <li data-index="0">{{ index+1 }}</li>
                    </ul>
                    <div class="toggle">
                        <button class="prev">&lt;</button>
                        <button class="next">&gt;</button>
                    </div>
                </div>
              </div>
            </div> -->


            <div class="slides">
        <transition-group tag="div" :name="transitionName" class="img-boxex">
            <div v-for="(img, idx) of imgs" :key="idx"
                 class="img-box" v-show="idx === showImg">
                <img class="boximg" :src="imgUrl(img.advertisePictureName)"/>
                <!-- <span>{{ idx + 1 }}</span> -->
            </div>
        </transition-group>
        <div class="btn-group">
            <button class="prev" @click="setShowImg(-1)">«</button>
            <button class="pages" @click="setShowImgTo(num - 1)"
                    v-for="num in imgs.length" :key="num - 1">{{ num }}
            </button>
            <button class="next" @click="setShowImg(1)">»</button>
        </div>
    </div>


        </div>
        <ul class="item_list">
            <li data-bs-toggle="modal" data-bs-target=".goods" @click="stop($event,item.productId)" v-for="item in list" :key="item.productId">
                <a href="#">
                    <div class="img_block">
                        <img class="blockimg" :src="imgUrl(item.productPictureName)">
                    </div>
                    <div class="libox">
                      <span class="item_texts">{{item.productIntroduction}}
全頻設計 / 高解析度 / 内容廣泛 / 1G+4G記憶體 / 多核心處理</span>
                      <span class="item_text">NT${{item.productPrice}}</span>
                      </div>
                    
                </a>
            </li>
        </ul>
<!-- 阮老師 -->
        <div class="page">
            <ul class="pagination">
                <li :class="page<=1?'disabled':''"  @click="prePage($event)"><a href="#">«</a></li>
                <li v-for="pageTotal in pageTotals" :key="pageTotal" ><a href="#" :class="{'active': (page === (pageTotal))}" @click="curPage($event,pageTotal)">{{pageTotal}}</a></li>
                <li :class="page>=1?'disabled':''" @click="nextPage($event)"><a  href="#">»</a></li>
            </ul>
        </div>
    </main>
            <HmCartDetail :item="itemList"></HmCartDetail>
    </div>
</template>

<script>
import Bus from '../utils/EventBus'
import HmCartDetail from '@/components/HmCartDetail.vue'
import axios from 'axios'


const autoPlayInterval = 5000;
export default {
    name:'StorePage',
    components:{
      HmCartDetail
    },
    data(){
      return{
        transitionName: "right-in",
        showImg: 0,
        imgsCount: 8,
        imgs:[],
        list:[],
        itemList:[],
        searchText:'',
        searchPrice1:0,
        searchPrice2:1000,
        page:1,
        pageSize:8,
        pageTotals:[],
        total:1
      }
    },methods:{ 
      getPage(i){
        if(i){
            this.page=i  
        }else{
            this.page=1             
        }
        axios.get(`http://localhost:8005/homie-demo/searchAll?page=${this.page}&pageSize=${this.pageSize}&searchText=${this.searchText}&searchPrice1=${this.searchPrice1}&searchPrice2=${this.searchPrice2}`).then(res =>{          
           this.list =  res.data.data.rows
           this.total = res.data.data.total
           this.pageTotals = Math.ceil(res.data.data.total/this.pageSize);
          })   
     },
      curPage(e,pageTotal){
        e.preventDefault()
      this.getPage(pageTotal);
      },
      prePage(e){
        e.preventDefault()
        if(this.page>1){
        this.page--;
        this.getPage(this.page);
        } 
      },nextPage(e){
        e.preventDefault()
        if(this.page<this.pageTotals){
        this.page++;
        this.getPage(this.page);
        }
      },
      imgUrl(img){
        return require("@/assets/images/"+img+".jpg")
      },
      stop(e,id){
        e.preventDefault()
        console.log(id)
        axios.get(`http://localhost:8005/homie-demo/search/${id}`).then(res=>{
            this.itemList=res.data.data
          })
        Bus.$emit("num",1)
      },search(){
          this.getPage()
        },
        setShowImg(changeIdx = 1) {
            switch (true) {
                case changeIdx === 1 && this.showImg === this.imgs.length - 1:
                    this.showImg = 0;
                    break;
                case changeIdx === -1 && this.showImg === 0:
                    this.showImg = this.imgs.length - 1;
                    break;
                default:
                    this.showImg = this.showImg + changeIdx;
                    break;
            }
        },
        setShowImgTo(changeIdxTo) {
            this.showImg = changeIdxTo;
        }
    },mounted(){
        this.getPage()
        axios.get("http://localhost:8005/homie-demo/advertise").then(res=>{
          console.log(res.data.data)
          this.imgs=res.data.data
        })
        setInterval(this.setShowImg, autoPlayInterval);
    },
    watch: {
        showImg(nIdx, oIdx) {
            this.transitionName = nIdx > oIdx ? "right-in" : "left-in";
        }
    }
}
</script>

<style>
/* Chrome, Safari, Edge, Opera */
input[type=number]::-webkit-outer-spin-button,
input[type=number]::-webkit-inner-spin-button {
  -webkit-appearance: none;
  margin: 0;
}

.blockimg{
  width: 100%;
}

.it{
  position: absolute;
  left: 68px;
  width: 30px;
  text-align: center;
}
#price1{
  width: 75px;
  padding-left: 10px;
  height: 34px;
  left:45px
}
#price2{
  width: 75px;
  padding-left: 10px;
  height: 34px;
}
.boxProduct span{
  position: relative;
  display:inline-block;
  top:0px;
  height: 34px;
  padding: 0 5px;
  background-color: #1085bc;
  line-height: 34px;
  font-size: 15px;
  color: #ddd;
  z-index: 10;
}
.boxProduct input{
  position: absolute;
  right: 19px;
  width: 150px;
}

.new-todo {
  padding: 16px;
  border: 1px solid #1085bc;
  box-shadow: inset 0 -2px 1px rgba(0, 0, 0, 0.03);
  height: 10px;
}
.boxProduct{
  padding-bottom: 15px;
}

a.aa:hover {
    color: #1085bc;
   }

   :root {
    --header-height: 60px;
    --aside-width: 240px;
  }
  body {
    margin: 0;
  }
  img {
    max-width: 100%;
    height: 250px;
  }
  :root {
    --header-height: 60px;
    --aside-width: 240px;
  }
 

  /* ==================== aside 區域 ==================== */
  aside.aside {
    /* border: 1px solid blue; */
    position: fixed;
    top: var(--header-height);
    left: 0;
    height: calc(100% - var(--header-height));
    width: var(--aside-width);
    background-color: #ffffff;
    overflow-y: auto;
    padding: 20px 0;
    transition: all 1s;
  }
  aside.aside button.btn_hamburger {
    display: none;
  }
  @media screen and (max-width: 767px) {
    aside.aside {
      top: 0;
      height: 100%;
      transform: translateX(-100%);
    }

    aside.aside.-on {
      transform: translateX(0%);
    }

    header.header button.btn_hamburger,
    aside.aside button.btn_hamburger {
      display: inline-block;
    }
  }

  /* aside.aside>nav.nav>ul.nav_list {
    margin: 0;
    padding: 0;
    list-style: none;
  }

  aside.aside>nav.nav>ul.nav_list>li>a {
    display: inline-block;
    border: 1px solid lightblue;
    width: 100%;
    padding: 3px 10px;
    text-decoration: none;
  } */

  /* ==================== main 區域 ==================== */
  main.main {
    /* border: 1px solid red; */
    margin-left: var(--aside-width);
    width: calc(100% - var(--aside-width));
    padding: 20px;
    background-color: hwb(0 95% 5%);
    min-height: calc(100vh - var(--header-height));
    transition: all 1s;
    margin-top: 80px;
  }

  @media screen and (max-width: 767px) {
    main.main {
      width: 100%;
      margin:0 20px;
    }
  }

  main.main ul.item_list {
    margin: 0;
    padding: 0;
    list-style: none;
    display: flex;
    flex-wrap: wrap;
  }

  main.main ul.item_list>li {
    width: calc((100% - 60px) / 4);
    margin-bottom: 20px;
    margin-right: 20px;
  }

  @media screen and (max-width: 767px) {
    main.main ul.item_list>li {
      width: calc((100% - 20px) / 2);
    }
  }

  main.main ul.item_list>li:nth-child(4n) {
    margin-right: 0;
  }

  @media screen and (max-width: 767px) {
    main.main ul.item_list>li:nth-child(2n) {
      margin-right: 0;
    }
  }

  main.main ul.item_list>li>a {
    display: inline-block;
    /* border: 1px solid red; */
    text-decoration: none;
    width: 100%;
  }

  main.main ul.item_list>li>a div.img_block {
    /* border: 1px solid blue; */
    font-size: 0;
  }

  main.main ul.item_list>li>a span.item_text {
    /* border: 1px solid blue; */
    background-color: white;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    display: block;
    width: 100%;
    padding: 0px 15px;
    padding-bottom: 15px;
    font-size: 20px;
    color: #d52020;
  }
  main.main ul.item_list>li>a span.item_texts {
    /* border: 1px solid blue; */
    background-color: white;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    display: block;
    width: 100%;
    padding: 20px 10px 0;
    padding-bottom: 15px;
    color: #606060;
  }

  .search{
    width :calc(100% - var(--aside-width))-40;
    height: 400px;
    background-color: #ffffff;
    margin-bottom: 20px;
    border:1px solid #e3e3e3;
    box-shadow: 0 0 15px 10px #ededed; 
  }

  #se{
    width: 150px;
    padding: 3px 5px;
    margin-bottom: 10px;
  }
  .serachin{
    margin-top: 30px;
    padding-left: 10px;
  }
  .serachin > .labtx{
    position: relative;
    font-size: 12px;
  }


/* 輪播圖 */
/* .slider {
  width: 100%;
  height: 400px;
  overflow: hidden;
}

.slider-wrapper {
  width: 100%;
  height: 320px;
}

.slider-wrapper img {
  width: 100%;
  height: 100%;
  display: block;
}

.slider-footer {
  height: 80px;
  background-color: rgb(100, 67, 68);
  padding: 12px 12px 0 12px;
  position: relative;
}

.slider-footer .toggle {
  position: absolute;
  right: 0;
  top: 12px;
  display: flex;
}

.slider-footer .toggle button {
  margin-right: 12px;
  width: 28px;
  height: 28px;
  appearance: none;
  border: none;
  background: rgba(255, 255, 255, 0.1);
  color: #fff;
  border-radius: 4px;
  cursor: pointer;
}

.slider-footer .toggle button:hover {
  background: rgba(255, 255, 255, 0.2);
}

.slider-footer p {
  margin: 0;
  color: #fff;
  font-size: 18px;
  margin-bottom: 10px;
}

.slider-indicator {
  margin: 0;
  padding: 0;
  list-style: none;
  display: flex;
  align-items: center;
}

.slider-indicator li {
  width: 8px;
  height: 8px;
  margin: 4px;
  border-radius: 50%;
  background: #fff;
  opacity: 0.4;
  cursor: pointer;
}

.slider-indicator li.active {
  width: 12px;
  height: 12px;
  opacity: 1;
} */

/* 分頁 */
.page{
  text-align: center;
}
ul.pagination {
  display: inline-block;
  padding: 0;
  margin: 0;
}

ul.pagination li {display: inline;}

ul.pagination li a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

ul.pagination li a.active {
  background-color: #1085bc;
  color: white;
}

ul.pagination li a:hover:not(.active) {
  background-color: #ddd;
}

.aside >.searchitem{
margin-top: 20px;
padding: 3px 89px;
position:absolute;
left: 10px;
border: none;
color: #efefef;
background-color: #1085bc;
cursor: pointer;
}
nav >ul >li:first-child {
  line-height: 5vw;
  }
  nav >ul >li:first-child img{
      width: 1.5vw;
      height: 1.5vw;
      cursor: pointer;
      margin-right: 10px;
      position: relative;
      top:5px;
  }
  /* 輪播圖 */
.slides{
  height: 400px;
  position: relative;
}
.img-boxex {
    position: relative;
    overflow: hidden;
    width: 1252px;
    height: 400px;
}

.img-box {
    position: absolute;
}

.right-in-enter {
    left: 100%;
}

.right-in-enter-active,
.right-in-leave-active {
    transition: left 0.5s;
}

.right-in-enter-to,
.right-in-leave {
    left: 0%;
}

.right-in-leave-to {
    left: -100%;
}

.left-in-enter {
    right: 100%;
}

.left-in-enter-active,
.left-in-leave-active {
    transition: right 0.5s;
}

.left-in-enter-to,
.left-in-leave {
    right: 0%;
}

.left-in-leave-to {
    right: -100%;
}
.btn-group{
  position: absolute;
  bottom: 20px;
  right:434px;
}
.btn-group button{
  padding: 3px 15px;
  border: none;
  background-color:#888888 ;
  opacity: 0.6;
  color: rgb(255, 254, 254);
  
}
.pages{
  margin: 0 10px;
}
.boximg{
  width: 1252px;
  height: 400px;

}
</style>