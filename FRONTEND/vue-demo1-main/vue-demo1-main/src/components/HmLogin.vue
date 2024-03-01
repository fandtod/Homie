<template>
  <div>
    <div class="loginpage">
      <div id="container">
        <div class="login" >
          <p>登入頁面</p>
          <form method="post">
            <input type="text" @keyup.enter="login" class="sc" id="username" name="帳號" placeholder=" 帳號" 
              onfocus="this.placeholder = ''" onblur="this.placeholder = ' 信箱'" required @change="changeHandle($event)" v-model="userInfo.userAccount">
            <span class="msg span1"></span>
            <input type="password" @keyup.enter="login"  class="sc" id="password" name="密碼" placeholder=" 密碼"
              onfocus="this.placeholder = ''" onblur="this.placeholder = ' 密碼'" required @change="changeHandles($event)" v-model="userInfo.userPassword">
            <span class="msg span2"></span>
            <input type="button" @keyup.enter="login" @click="login" value="登入" class="loginb">
          </form>
        </div>
        <div class="agplace">
          <hr>
          <div>
            <router-link class="agtext" to="/register">註冊帳號</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<!-- /^[a-zA-Z0-9-_]{6,12}$/ -->
<script>
import Bus from '../utils/EventBus'
import axios from 'axios'
export default {
    data(){
        return{
          userInfo:{
            userAccount:'',
            userPassword:''
          },
          userId:1
            
        }
    },methods:{
        changeHandle(e){
            // console.log(e.target.value)
            const span = e.target.nextElementSibling
            const reg =/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
            if(!reg.test(e.target.value)){
                span.innerHTML=`信箱格式錯誤`
                return false
            }
            span.innerHTML=''
            return true
            },changeHandles(e){
            // console.log(e.target.value)
            const span = e.target.nextElementSibling
            const reg =/^[a-zA-Z0-9-_]{6,12}$/
            if(!reg.test(e.target.value)){
                span.innerHTML=`${e.target.name}密碼錯誤，請輸入6~12位`
                return false
            }
            span.innerHTML=''
            return true
            },
        login(){        
          axios.post("http://localhost:8005/homie-demo/login",this.userInfo).then(res =>{console.log(res.data.data.userId)
            let code =res.data.code
            if(code==1){              
              this.userId=res.data.data.userId
              localStorage.setItem('uname',this.userInfo.userAccount)
              localStorage.setItem('uid',this.userId) 
              Bus.$emit('userId',this.userId) 
              Bus.$emit('refresh','true')    
              this.$router.push({path:'/home'})
              this.$router.go(0)  
              return true           
            }else{
              alert(res.data.msg)
              return false
            }
          }).catch(error=>{
            console.log(error)
            alert("用戶輸入錯誤")
          })
          
          
        }
    },mounted(){
     
    }
}

</script>

<style scoped>
#container{
  padding: 10px;
  width: 350px;
  height: 400px;
  background-color: white;
  border-radius: 5px;
  border-top: 20px solid #3daaa5;
  box-shadow: 0 0px 70px rgba(0, 0, 0, 0.1);
  

  position:relative;   
  margin: auto;
  top: 150px;
  text-align:center;  
}

input{
    margin-top: 1.25rem;
}
.msg{
    display: flex;
    position: absolute;
    margin-left: 65px;
    font-size:0.65rem;
    color: #d32424;
}
.loginb{
    width: 200px;
    background-color: #3daaa5;
    border : 1px solid #cecece;
    padding: 3px 0px;
    color: #ffffff;
    cursor: pointer;
}
.sc{
    width: 200px;
    height: 25px;
}
.agtext{
    color:#666 ;
    font-size: 0.75rem;
    cursor: pointer;
    padding-top: 5px;
}
.agplace{
    position: absolute;
    text-align: center;
    top:320px;
    right: 50px;
}
hr{
    width: 250px;
    top:10px;
    margin: auto;
}
a.aa:hover {
    color: #1085bc;
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
</style>