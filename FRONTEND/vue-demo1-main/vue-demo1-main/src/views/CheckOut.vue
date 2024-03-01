<template>
  <div>
    <div class="Hm-Header">
    <div class="logo">
            <a href="#/home"><img class="imglogo" src="../assets/images/—Pngtree—homestay house logo_5396744.png"
                    alt="logo" /></a>
            <a href="#/home">
                <h1>Clean House</h1>
            </a>
    </div>
  </div>



    <div class="app-container" id="app">

      <div class="breadcrumb">
        <span>🏠</span>
        /
        <span>結帳頁面</span>
      </div>
      <div class="main">
        <div class="table">
          <div class="thead">
            <div class="tr">
              <div class="th th-pic">圖片</div>
              <div class="th">商品</div>
              <div class="th">單價</div>
              <div class="th num-th">數量</div>
              <div class="th">小計</div>
              <!-- <div class="th">操作</div> -->
            </div>
          </div>
          <div class="tbody" v-for="item in cartCheckList" :key="item.productId">
            <div class="tr active">
              <div class="td"><img :src="imgUrl(item.cartPictureName)" alt="" /></div>
              <div class="td">{{ item.cartName }}</div>
              <div class="td">NT${{ item.cartPrice }}</div>
              <div class="td">
                  <span class="">{{item.cartNum}}</span>
              </div>
              <div class="td">NT${{item.cartPrice*item.cartNum}}</div>
              <!-- <div class="td"><button @click="del(item.productId)">删除</button></div> -->
            </div>       
          </div>
        </div>
        <div class="bottom">
          <div class="right-box">
            <span class="price-box">總價&nbsp;&nbsp;:&nbsp;&nbsp;NT$&nbsp;<span class="price">{{totalPrices}}</span></span>
          </div>
        </div>
      </div>
    </div>

    <div class="baypage">
      <div class="breadcrumb">
        <span class="payspan">送貨資訊</span>
      </div>
        <div class="mainpage">
          <table>
            <ul class="payul"> 
              <div>            
                <label for="name">姓名</label>
                <input v-model="userInfo.userName"  type="text" id="name" required>   
              </div>
              <div> 
                <label for="phone">電話 </label>
                <input v-model="userInfo.userPhone"   type="text" id="phone" required>
              </div>                         
                <label for="add">地址 </label>
                <input v-model="userInfo.userAddress"  type="text" id="add" required>                           
            </ul>
        </table>
        </div>
        
    </div>

    <div class="bpage">
      <div class="breadcrumb">
        <span class="payspan">付款方式</span>
      </div>
        <div class="endpage">
          <table class="paytable">    
            <div class="tableitem">
              <input type="radio" id="huey" name="drone"  checked />
              <label for="huey" style="font-size: 18px;padding: 0 5px;color: rgb(151, 151, 151);">貨到付款</label>
            </div>  
            <div class="tableitem">
              <input disabled type="radio" id="huey" name="drone"  />
              <label for="huey" style="font-size: 18px;padding: 0 5px;color: rgb(151, 151, 151);">LinePay</label>
            </div>   
            <div class="tableitem">
              <input disabled type="radio" id="huey" name="drone"  />
              <label for="huey" style="font-size: 18px;padding: 0 5px;color: rgb(151, 151, 151);">ApplePay</label>
            </div>                         
        </table>
        </div>
        <div >
          <button class="pays" @click="changeInfo"  @keyup.enter="changeInfo">結帳</button>
        </div>
    </div>
  </div>
</template>

<script>
// import Bus from '../utils/EventBus'
import axios from 'axios'
export default {
         name:"CheckOutPage",
         data(){
          return{
            cartCheckList:[],
            totalCount:1,
            nowDate:"" ,
            totalPrice:1,
            cartdelList:[],
            
            userInfo:{
                userName:"",  
                userPhone:"",
                userAddress:"",               
            }
          }
         },created(){
          // Bus.$on('cartCheckList',(list)=>{
          //   console.log(list) 
          //   this.cartCheckList=list                                                
          // }),
          const uid = localStorage.getItem('uid')
          this.userId=uid
          axios.get(`http://localhost:8005/homie-demo/userall/${this.userId}`).then(res=>{
            this.userInfo.userName=res.data[0].userName
            this.userInfo.userPhone=res.data[0].userPhone
            this.userInfo.userAddress=res.data[0].userAddress
        })
          
         },computed:{
          totalCounts() {
                    return this.cartCheckList.reduce((sum, item) => {
                        if (item.checked) {                          
                            return sum + item.cartNum
                        } else return sum
                    }, 0)
                },
                totalPrices() {
                    return this.cartCheckList.reduce((sum, item) => {
                        if (item.checked) {
                            return sum + item.cartPrice * item.cartNum
                        } else return sum
                    }, 0)
                },
         },methods:{
          changeInfo(){
                axios.put(`http://localhost:8005/homie-demo/informations/${this.userId}`,this.userInfo).then(res=>{
                console.log(res)
            }),
                axios.put(`http://localhost:8005/homie-demo/orderproduct/${this.userId}/${this.totalPrices}`,this.cartCheckList).then(res=>{
                  console.log(res)
            })
            axios.delete(`http://localhost:8005/homie-demo/cartdels/${this.userId}`,{data:this.cartdelList}).then(res=>{
                        console.log(res)
                    })
                    console.log(this.cartdelList)
                      
                   
            this.$router.push({path:'/checkoutpage'})

           },
            currentTime() {
              setInterval(this.formatDate, 500);
            },
           formatDate() {
              let date = new Date();
              let year = date.getFullYear(); // 年
              let month = date.getMonth() + 1; // 月
              let day = date.getDate(); // 日
              // let week = date.getDay(); // 星期
              // let weekArr = [ "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" ];
              let hour = date.getHours(); // 时
              hour = hour < 10 ? "0" + hour : hour; // 如果只有一位，则前面补零
              let minute = date.getMinutes(); // 分
              minute = minute < 10 ? "0" + minute : minute; // 如果只有一位，则前面补零
              let second = date.getSeconds(); // 秒
              second = second < 10 ? "0" + second : second; // 如果只有一位，则前面补零
              this.userInfo.nowDate = `${year}/${month}/${day} ${hour}:${minute}:${second} `;
            },
          imgUrl(img){
                    return require("@/assets/images/"+img+".jpg")
            },
          del(id) {                            
                    this.cartCheckList=this.cartCheckList.filter(item => item.productId!==id)                        
                },
         },mounted(){
          this.cartCheckList=JSON.parse(localStorage.getItem('list'))
          this.currentTime();
          this.cartdelList=this.cartCheckList.map(item =>item.productId)
         },
          beforeDestroy() {
            if (this.formatDate) {
              clearInterval(this.formatDate); 
            }
          }
}
</script>

<style scoped>
input{
  padding: 0 5px;
}
.tableitem{
  padding-left: 10px;
}
.paytable{
  display: flex;
  padding: 10px;
}
.payspan{
  margin-left: 60px;
  margin-top: 15px;
  font-size: 18px;
}
.payul{
  display: block;
  width: 600px;
  margin-left:15px ;
  margin-top: 20px;
}
.payul input{
  width: 600px;
  line-height: 40px;
  display: flex;
  margin: 0 auto;

}
.endpage{
  position: absolute;
  width: 700px;
  height:100px;
  right: 45px;
  padding: 10px;
  margin: 0 auto;
  margin-top: 50px;
  border: 3px solid #ececec;
  border-radius: 2px 2px 0 0;
}
.mainpage{
  position: absolute;
  width: 700px;
  height:270px;
  right: 45px;
  margin: 0 auto;
  margin-top: 50px;
  border: 3px solid #ececec;
  border-radius: 2px 2px 0 0;
}
.baypage{
  position: relative;
  width: 800px;
  height:380px;
  display: flex;
  margin: 0 auto;
  margin-bottom: 100px;
  margin-top: -50px;
  border: 2px solid #ececec;
  border-radius: 2px 2px 0 0;
}
.bpage{
  position: relative;
  width: 800px;
  height:230px;
  display: flex;
  margin: 0 auto;
  margin-bottom: 100px;
  margin-top: -50px;
  border: 2px solid #ececec;
  border-radius: 2px 2px 0 0;
}
.pays{
  width: 100px;
    background-color: #3f85ed;
    position: absolute;
    bottom: 18px;
    right:50px
}
.app-container {
  padding-bottom: 80px;
  width: 800px;
  margin: 0 auto;
  margin-top: 130px;
}
@media screen and (max-width: 800px) {
  .app-container {
    width: 600px;
  }
}
.app-container .banner-box {
  border-radius: 20px;
  overflow: hidden;
  margin-bottom: 10px;
}
.app-container .banner-box img {
  width: 100%;
}
.app-container .nav-box {
  background: #ddedec;
  height: 60px;
  border-radius: 10px;
  padding-left: 20px;
  display: flex;
  align-items: center;
}
.app-container .nav-box .my-nav {
  display: inline-block;
  background: #5fca71;
  border-radius: 5px;
  width: 90px;
  height: 35px;
  color: white;
  text-align: center;
  line-height: 35px;
  margin-right: 10px;
}

.breadcrumb {
  font-size: 16px;
  color: gray;
}
.table {
  width: 100%;
  text-align: left;
  border-radius: 2px 2px 0 0;
  border-collapse: separate;
  border-spacing: 0;
}
.th {
  color: rgba(0, 0, 0, 0.85);
  font-weight: 500;
  text-align: left;
  background: #fafafa;
  border-bottom: 1px solid #f0f0f0;
  transition: background 0.3s ease;
}
.th.num-th {
  flex: 1.4;
}
.th {
  text-align: center;
}
.th:nth-child(4),
.th:nth-child(5),
.th:nth-child(6),
.th:nth-child(7) {
  text-align: center;
}
.th.th-pic {
  flex: 1.3;
}
.th:nth-child(6) {
  flex: 1.3;
}

.th,
.td {
  position: relative;
  padding: 16px 16px;
  overflow-wrap: break-word;
  flex: 1.2;
}
.pick-td {
  font-size: 14px;
}
.main,
.empty {
  border: 1px solid #f0f0f0;
  margin-top: 10px;
}
.tr {
  display: flex;
  cursor: pointer;
  border-bottom: 1px solid #ebeef5;
}
.tr.active {
  background-color: #f5f7fa;
}
.td {
  display: flex;
  justify-content: center;
  align-items: center;
}

.table img {
  width: 100px;
  height: 100px;
}

button {
  outline: 0;
  box-shadow: none;
  color: #fff;
  background: #d9363e;
  border-color: #d9363e;
  color: #fff;
  background: #d9363e;
  border-color: #d9363e;
  line-height: 1.5715;
  position: relative;
  display: inline-block;
  font-weight: 400;
  white-space: nowrap;
  text-align: center;
  background-image: none;
  border: 1px solid transparent;
  box-shadow: 0 2px 0 rgb(0 0 0 / 2%);
  cursor: pointer;
  transition: all 0.3s cubic-bezier(0.645, 0.045, 0.355, 1);
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  user-select: none;
  touch-action: manipulation;
  height: 32px;
  padding: 4px 15px;
  font-size: 14px;
  border-radius: 2px;
}
.bottom {
  height: 60px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  border: 1px solid #f0f0f0;
  border-top: none;
  padding-left: 20px;
}
.right-box {
  display: flex;
  position: relative;
  left: 650px;
  padding-bottom: 15px;
  align-items: center;
}
.check-all {
  cursor: pointer;
}
.price {
  color: rgb(234, 124, 148);
  font-size: 30px;
  font-weight: 700;
}
.price-box {
  display: flex;
  position: relative;
  align-items: center;
  right: 80px;
  font-size: 20px;
}

.empty {
  padding: 20px;
  text-align: center;
  font-size: 30px;
  color: #909399;
}
.my-input-number {
  display: flex;
}
.my-input-number button {
  height: 40px;
  color: #333;
  border: 1px solid #dcdfe6;
  background-color: #f5f7fa;
}
.my-input-number button:disabled {
  cursor: not-allowed!important;
}
.my-input-number .my-input__inner {
  height: 40px;
  width: 50px;
  padding: 0;
  text-align: center;
  padding-top: 8px;
  border: none;
  border-top: 1px solid #dcdfe6;
  border-bottom: 1px solid #dcdfe6;
}

/* HEADER */
.Hm-Header nav ul li{
  display: inline-block;
  width: 100px;
  text-align: center;
}
.Hm-Header{
display: flex;
top:0;
right: 0;
align-items: center;
background-color: rgb(255, 255, 255);
flex-wrap: wrap;
box-shadow: 0 0 15px 10px #ededed; 
width: 100%;
position: fixed;
z-index: 1;
}
.logo{
    display: flex;
    align-items: center;
    flex:5 1 400px;
    margin-left: 1.5rem;
}
.logo a h1{
    font-size: 20px;
    padding-left: 10px;
    padding-top: 10px;
    color: rgb(100, 112, 127);
}
.imglogo{
    width: 5vw;
    height: 5vw;
}
</style>