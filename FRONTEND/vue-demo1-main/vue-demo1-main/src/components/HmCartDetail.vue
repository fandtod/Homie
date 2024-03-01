<template>
  <div >
    <div class="modal goods" tabindex="-1">
              <div class="modal-dialog modal-dialog-centered">
                <ul><li v-for="items in item" :key="items.productId">
                  <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title">商品頁面</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="left">
                              <img :src="imgUrl(items.productPictureName)" alt="">
                            </div>
                            <div class="right">
                              <h3 class="name">{{items.productIntroduction}}</h3>
                              <p class="desc">全頻設計 / 高解析度 / 内容廣泛 / 1G+4G記憶體 / 多核心處理</p>
                              <p class="price"><span class="now">NT${{items.productPrice}}</span><span class="old">NT$299</span></p>
                                <div class="address">
                                    <div class="item">
                                      <div class="dt">促销</div>
                                      <div class="dd">12月好物放送，App購買只要120元</div>
                                    </div>
                                    <div class="item">
                                      <div class="dt">配送</div>
                                        <div class="dd">
                                          至台北市
                                        </div>
                                    </div>
                                    <div class="item">
                                      <div class="dt">付款方式</div>
                                      <div class="dd">
                                        <span class="fw">LINE Pay /</span>
                                        <span class="fw"> Apple Pay /</span>
                                        <span class="fw">街口支付</span>
                                        <a href="#" class="lj"></a>
                                      </div>
                                    </div>
                                    <div class="num">
                                      <a id="decreaseBtn" @click="sub">-</a>
                                      <input type="text" id="quantity" v-model="cartList.cartNum">
                                      <a id="increaseBtn" @click="add">+</a>                                      
                                    </div>
                                      
                                    <br>
                                    <button @click="addcart" type="button" class="btn btn-primary" data-bs-dismiss="modal">加入購物車</button>
                                </div>
                            </div>
                      </div>                 
                  </div>
                </li></ul>
              </div>
            </div>
  </div>
</template>

<script>
import axios from 'axios'
import Bus from '../utils/EventBus'
export default {
    props:{
      item:{
        type:Array
    }
  },
    data(){
      return{
        cartList:{
          userId:1,
          productId:1,
          cartName:"",
          cartPrice:1,
          cartNum:1,
          cartIntroduction:"",
          cartPictureName:"" 
        }
                
      }
    },created(){   
      Bus.$on('num',(list)=>{
            this.cartList.cartNum=list
        })

    },methods:{
      
      addcart(){
        
        Bus.$emit('addCart',this.item[0])
        const uid = localStorage.getItem('uid')
        if(uid!=null){
          let cartName = this.item[0].productName
        let cartPrice = this.item[0].productPrice
        let productId = this.item[0].productId
        let cartIntroduction = this.item[0].productIntroduction
        let cartPictureName = this.item[0].productPictureName
        this.cartList.userId=uid
        this.cartList.cartName = cartName
        this.cartList.cartPrice = cartPrice
        this.cartList.productId = productId
        this.cartList.cartIntroduction = cartIntroduction
        this.cartList.cartPictureName = cartPictureName
        console.log(this.cartList.userId)
        console.log(this.cartList.productId)
        // console.log(this.cartName)
        // console.log(this.cartPrice)
        // console.log(this.cartList.cartNum)
        // console.log(this.cartIntroduction)
        // console.log(this.cartPictureName)

        axios.post("http://localhost:8005/homie-demo/addcart",this.cartList).then(res =>{
          console.log(res)
          Bus.$emit('refresh','true')
        })
        }else{
          alert('請先登入會員')
          this.$router.push({path:'/login'})
        }
        
        
      },add() {
          this.cartList.cartNum++
              },
      sub() {
        if(this.cartList.cartNum==1){
          this.cartList.cartNum=1
        }else
          this.cartList.cartNum-- 
                },
      imgUrl(img){
        return require("@/assets/images/"+img+".jpg")
      },
    },watch:{
     
    }
}
</script>

<style scoped>
.btn-primary{
  background-color: #1085bc;
  padding: 5px 15px;
}
.modal-header{
  height: 60px;
}
.price .old {
    color: #999;
    text-decoration: line-through;
    font-size: 18px;
}
.price .now {
    color: #CF4444;
    margin-right: 5px;
    font-size: 22px;
}
.right .item .dd {
    flex: 1;
    color: #666;
}
.right .item .dt {
    width: 80px;
}
.right .item {
    color: #999;
    display: flex;
    padding-top: 20px;
    align-items: center;
}
.right .address {
    width: 400px;
    background: #f9f9f9;
    padding: 0 10px 20px;
}
.right {
  width: 600px;
}
.modal-header h5{
  color: #747474;
  font-size: 26px;
}
.num{
  width: 116px;
  height: 28px;
  border: 1px solid #e4e4e4;
  display: flex;
  justify-content: center;
  margin-top:15px ;
}
.num input{
  line-height: 26px;
  text-align: center;
  color: #979797;
  border-left: 1px solid #e4e4e4;
  border-right: 1px solid #e4e4e4;
  width: 60px;
  margin: 0 3px;
}
input{
  border: none;
}
.num a{
  width: 23px;
  text-align: center;
  line-height: 24px;
  color: #979797;
  cursor: pointer;
}
.hh{
  height: 50px;
}
.modal-body .right{
  padding: 20px;
}
.modal-body{
  display: flex;
}
.left img{
  width:520px;
  height: 400px;
  padding:15px 0 0 5px;
}
.modal-header{
  padding:0 30px 0 10px ;
}
.modal {
  --bs-modal-width: 900px;
}
.modal-content{
  top:10px;
  height: 550px;
}
</style>