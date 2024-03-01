<template>
    <li class="cart">
                      <img src="../assets/images/shopping-cart.png" alt="">
                      <a href="#">購物車({{cartList.length}})</a>
                      <div class="cart-list">
                          <div class="maincart" v-if="cartList.length > 0">
                              <div class="sbox" v-for="item in cartList" :key="item.productId">
                                  <div class="schecked">
                                      <input type="checkbox" v-model="item.checked"  />
                                  </div>
                                  <div class="simg">
                                      <img :src="imgUrl(item.cartPictureName)" alt="" />
                                  </div>
                           
                                    <h2 class="h2">{{ item.cartName }}</h2>
                             
                                  
                                  <p class="prices">NT${{item.cartPrice}}</p>
                                  <input type="button" class="x" value="X" @click="del(item.productId)">
                                  <div class="sborder">
                                      <button @click="sub(item.productId)">-</button>
                                      <span>{{item.cartNum}}</span>
                                      <button @click="add(item.productId)">+</button>
                                  </div>
                              </div>
                          </div>
                          <div class="empty" v-else>
                              <div class="sboxend">
                                  無任何商品
                              </div>
                          </div>
                          <div class="totalbox">
                              <label class="checkall">
                                  <input type="checkbox" class="checkbox" style="vertical-align:middle;"
                                      v-model="allCheck">&nbsp;全選
                              </label>
                              <span class="pricebox">
                                  總計&nbsp;&nbsp;:&nbsp;&nbsp;NT&nbsp;
                                  <span class="price">{{totalPrice}}</span>
                              </span>
                              <button class="pay" @click="checkout">結帳({{totalCount}})</button>
                              
                          </div>
  
                      </div>
                  </li>
  </template>

<script>
// import Bus from '../utils/EventBus'
import axios from 'axios'

        // JSON.parse(localStorage.getItem('list'))||
export default {
    data (){
        return{
            cartList:[],
            userId:1,  
            cartCheckList:[],       
        }
    }
    ,created(){
        this.getlist()
        // Bus.$on('list',(list)=>{
        //     console.log(list)                                                  
        // })
    },
    computed: {
                allCheck: {
                    get(){
                    return this.cartList.every(item=>item.checked)
                    },
                    set(val){          
                        this.cartList.forEach(element => {
                            element.checked=val
                        });
                }},               
                totalCount() {
                    return this.cartList.reduce((sum, item) => {
                        if (item.checked) {                          
                            return sum + item.cartNum
                        } else return sum
                    }, 0)
                },
                totalPrice() {
                    return this.cartList.reduce((sum, item) => {
                        if (item.checked) {
                            return sum + item.cartPrice * item.cartNum
                        } else return sum
                    }, 0)
                },
            },mounted(){
                
            },updated(){
               
            },
            methods: {  
               
                checkout(){
                    // axios.get(`http://localhost:8005/homie-demo/cartchecked/${this.userId}`).then(res =>{
                    //     console.log(res.data.msg)                      
                    //     if(res.data.code ==0){
                    //         alert(res.data.msg)
                    //     }else{
                    //         this.cartCheckList=res.data.data
                    //         this.$router.push({path:'/checkout'})
                    //     }
                    // })
                //     this.cartList.filter(item => {if(item.checked!==false){
                //     this.cartCheckList.push(item)
                //    }
                //     console.log(item.checked)})
                //     console.log(e.target.checked)

                this.cartCheckList=this.cartList.filter(item =>item.checked==true)
                    if(this.cartCheckList.length==0){
                        alert("請選擇商品")
                    }else{
                        console.log(this.cartCheckList)
                        localStorage.setItem('list', JSON.stringify(this.cartCheckList))
                        this.$router.push({path:'/checkout'})
                        
                        
                            // Bus.$emit('cartCheckList',this.cartCheckList)                                  
                    }
                },
                getlist(){                
                    const uid = localStorage.getItem('uid')
                    this.userId=uid
                    if(uid!=null){
                        axios.get(`http://localhost:8005/homie-demo/cartall/${this.userId}`).then(res =>{                      
                        this.cartList=res.data
                })
                    }else{this.cartList=[]}
                    },
                imgUrl(img){
                    return require("@/assets/images/"+img+".jpg")
                },        
                
                del(id) {            
                    axios.delete(`http://localhost:8005/homie-demo/cartdel/${id}/${this.userId}`).then(res=>{
                        console.log(res)
                    })
                    this.cartList=this.cartList.filter(item => item.productId!==id)                        
                },
                add(id) {
                    axios.put(`http://localhost:8005/homie-demo/add/${id}/${this.userId}`).then(res=>{
                        console.log(res)
                    })
                    const addnum = this.cartList.find(item => item.productId === id)
                    addnum.cartNum++
                },
                sub(id) {
                    axios.put(`http://localhost:8005/homie-demo/sub/${id}/${this.userId}`).then(res=>{
                        console.log(res)
                    })
                    const subnum = this.cartList.find(item => item.productId === id)

                    if (subnum.cartNum === 1) {
                        this.cartList = this.cartList.filter(item => item.productId !== id)              
                    } else subnum.cartNum--
                    
                }
            },
            watch: {
                cartList: {
                    deep: true,
                    handler(newValue) {
                        // localStorage.setItem('list', JSON.stringify(newValue))
                        console.log(newValue)
                        
                        
                                            
                    }
                    
                }
                
            }
}
</script>

<style >
.h2{
    position: absolute;
    left: 120px;
    font-size: 12px;
    padding-left: 10px;
    padding-bottom: 10px;
}
.maincart{
    margin-bottom: 60px;
}
.cart{
    position: relative;    
    cursor: pointer;
}
.cart a{
    text-decoration: none;
    color:  rgb(100, 112, 127);
}

.cart>a:hover{
    color: #1085bc;
}
.cart img{
    width: 1vw;
    height: 1vw;
    padding-top: 3px;
    cursor: pointer;
}
.cart:hover>.cart-list{
    height: 300px;
    line-height: 200px;
    overflow:auto !important;
}
.cart:hover>.cart-list>.totalbox{
    top:331px;
}
nav>ul>li{
    line-height: 80px;
    
}
.cart-list{
    width: 280px;
    height: 0px;
    line-height: 200px;
    background-color: #fff;
    box-shadow: 0 2px 10px #ececec;
    position:absolute;
    right:0;
    top:80px;
    color: #464646;
    font-size: 12px;
    text-align: center;
    transition: all .01s;
    overflow: auto !important;
}

.totalbox{
    top:-600px;
    display: flex;
    align-items: center;  
    justify-content: center;
    flex-wrap: wrap;
    position:fixed;
    background-color: rgb(255, 255, 255);
    width: 263px;
    height:49px;
    bottom: 0;
}
.totalbox .checkall{
    position: absolute;
    left: 20px;
    top:-75px;
    height: 10px;
}
.pricebox{
    position: absolute;
}
.pay{
    color: #fff;
    background-color: #1085bc;
    width: 65px;
    height: 30px;
    border: none;
    padding: 0 5px;
    margin-top: 8px;
    margin-bottom: 10px;
    font-size: 12px;
    cursor: pointer;
    position: absolute;
    right:10px;
    line-height: 5px;
}
.sbox{
    position: relative;
    height: 80px;
    line-height: 10px;
    border:1px solid #e1e1e1;
    background-color: #ffffff;
    margin: 2px;
    display: flex;
    align-items: center;
    padding: 15px;
}
.sbox h4{
    position: absolute;
    top:20px;
    right:70px;
    font-size: 14px;
    font-weight: 500;
}
.sborder{
    position: absolute;
    top:50px;
    right:15px;
}
.simg img{
    margin-left: 10px;
    width:4.5vw;
    height:4.5vw;
}
.sbox button{
    height: 20px;
    width: 20px;
    border: .2px solid #d7d7d7;
    cursor: pointer;
    color: #616161;
    background-color: #efefef;
}
.sbox span{
    padding: 1px 12px 2px ;
    width: 25px;
    border-top: 1px solid rgb(218, 218, 218);
    border-bottom: 1px solid rgb(218, 218, 218);   
}

.mainbox{
    display: flex;
    width:800px ;
    height: 500px;
    border:1px solid #cccccc;

    position:relative;   
    margin: auto;
    top: 110px;
    text-align:center
}
label {
    font-size: 12px;
}
.prices{
    font-size: 12px;
    padding:45px 0px 0 10px;
  }
.x{
    position: absolute;
    top:0;
    right: 0;
    cursor: pointer;
    color: #ababab;
    background-color: #ffffff;
    width: 25px;
    height: 25px;
    border:none;
}
.x:hover{
    background-color: #1085bc;
    color: rgb(255, 255, 255);
}
</style>