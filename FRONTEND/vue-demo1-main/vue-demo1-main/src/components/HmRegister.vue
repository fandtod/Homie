<template>
    <div>
        <div class=" singuppage">
            <div id="container2">
                <div class="signup">
                    <p>註冊頁面</p>
                        <form method="post">
                            <input type="text" class="sc" id="username2" name="新帳號" placeholder=" 新帳號"
                            onfocus="this.placeholder = ''" onblur="this.placeholder = ' 帳號'"  @change="changeHandle($event)" v-model="userInfo.userAccount" required>
                               <span class="msg span1"></span>
                            <input type="text" class="sc" id="password2" name="新密碼" placeholder=" 新密碼"
                            onfocus="this.placeholder = ''" onblur="this.placeholder = ' 密碼'" required @change="changeHandles($event)" v-model="userInfo.userPassword">
                               <span class="msg span2"></span>
                            <input type="text" v-model="userInfo.comUserPassword" class="sc" id="comfirm_password" name="重複密碼" placeholder=" 重複密碼"
                            onfocus="this.placeholder = ''" onblur="this.placeholder = ' 確認密碼'" required  @change="changeHandlePassword($event)">
                               <span class="msg span3"></span>
                            <input type="button" @click="register" value="註冊" class="signupb">
                        </form>
                </div>

                <div class="agplace">
                <hr>
                    <div>
                        <router-link class="agtext" to="/login">登入帳號</router-link>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
    data(){
        return{
            userInfo:{
                userAccount:'',
                userPassword:'',
                comUserPassword:''
            },        
            mes:{
                mes1:'帳號格式錯誤，請輸入6~12位',
                mes2:'重複密碼錯誤'
            }
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
                },
        changeHandles(e){
            // console.log(e.target.value)
            const span = e.target.nextElementSibling
            const reg =/^[a-zA-Z0-9-_]{6,12}$/
            if(!reg.test(e.target.value)){
                span.innerHTML=`密碼錯誤，請輸入6~12位`
                return false
            }
            span.innerHTML=''
            return true
               },
        changeHandlePassword(e){                          
                const span = e.target.nextElementSibling
                if(this.userInfo.userPassword!==this.userInfo.comUserPassword){
                    span.innerHTML=this.mes.mes2
                    return false
                }
                span.innerHTML=''
                return true
        },
        register(){
            // let form = document.querySelector('form')
            // for(let i=0;i<form.length;i++){
            //     if(form.elements[i].value.trim()!==''){
            //         e.preventDefault()
            //         alert('格式輸入錯誤')   
            //         return false                
            //     }
            // }
            const span1 = document.querySelector('.span1')
            const span2 = document.querySelector('.span2')
            const span3 = document.querySelector('.span3')
            // if(this.newUsername==0&&this.newPassword==0&&this.comPassword==0){
            //     e.preventDefault()
            //     alert('不可為空')
            //     return false
            // }else if(span1.innerHTML.trim()!==''||span2.innerHTML.trim()!==''||span3.innerHTML.trim()!==''){
            //     e.preventDefault()
            //     alert('格式錯誤')
            //     return false
            // }else{
            //     alert('註冊成功')
            //     this.$router.push({path:'/login'})
            //     return true
            // }
            if(span1.innerHTML.trim()!==''||span2.innerHTML.trim()!==''||span3.innerHTML.trim()!==''){
                alert("錯誤格式")
            }else if(this.userInfo.userAccount==""&&this.userInfo.userPassword==""&&this.userInfo.comUserPassword==""){
               alert("不可為空")
            }else{
                axios.post("http://localhost:8005/homie-demo/register",this.userInfo).then(res =>{console.log(res.data)
            let code =res.data.code
            if(code==1){
                alert('註冊成功')
                this.$router.push({path:'/login'})
                return true           
            }else{
                alert(res.data.msg)
                return false
            }
          })
            }
            
        }
    }
  }
  </script>
  
  <style scoped>
 #container2{
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
.loginb,.signupb{
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