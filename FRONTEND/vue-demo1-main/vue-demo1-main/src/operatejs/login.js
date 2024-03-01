function showpage(){
   var login= document.querySelector("#container");
   var signup= document.querySelector("#container2");

   if (login.style.display === "none") {
    login.style.display ="block";
    document.querySelector("#username").value="";
    document.querySelector("#password").value="";
    signup.style.display = "none";
   }else{
    signup.style.display ="block";
    login.style.display = "none";
    signup.style.visibility="visible";

    document.querySelector("#username2").value="";
    document.querySelector("#password2").value="";
    document.querySelector("#comfirm_password").value="";
   }
}
// 帳號
const username = document.querySelector('[name=username]')
   username.addEventListener('change',verifyName)

   function verifyName(){
      const span = username.nextElementSibling
      const reg =/^[a-zA-Z0-9-_]{6,16}$/
      if(!reg.test(username.value)){
         span.innerHTML='帳號格式錯誤，請輸入6~12位'
         return false
      }
      span.innerHTML=''
      return true
   }

// 密碼
   const password = document.querySelector('[name=password]')
   password.addEventListener('change',verifyPasswordName)

   function verifyPasswordName(){
      const span = password.nextElementSibling
      const reg =/^[a-zA-Z0-9-_]{6,16}$/
      if(!reg.test(password.value)){
         span.innerHTML='密碼錯誤，請輸入6~10位'
         return false
      }
      span.innerHTML=''
      return true
   }

// 新帳號
const newUsername = document.querySelector('[name=newUsername]')
   newUsername.addEventListener('change',verifyNewName)

   function verifyNewName(){
      const span = newUsername.nextElementSibling
      const reg =/^[a-zA-Z0-9-_]{6,16}$/
      if(!reg.test(newUsername.value)){
         span.innerHTML='帳號格式錯誤，請輸入6~12位'
         return false
      }
      span.innerHTML=''
      return true
   }

// 新密碼
const newPassword = document.querySelector('[name=newPassword]')
newPassword.addEventListener('change',verifyNewPasswordName)

function verifyNewPasswordName(){
   const span = newPassword.nextElementSibling
   const reg =/^[a-zA-Z0-9-_]{6,16}$/
   if(!reg.test(newPassword.value)){
      span.innerHTML='密碼錯誤，請輸入6~10位'
      return false
   }
   span.innerHTML=''
   return true
}

// 重複密碼
const comfirmPassword = document.querySelector('[name=comfirmPassword]')
comfirmPassword.addEventListener('change',verifyComfirmPasswordName)
function verifyComfirmPasswordName(){
   const span = comfirmPassword.nextElementSibling
   if(comfirmPassword.value!==newPassword.value){
      span.innerHTML='重複密碼錯誤'
      return false
   }
   span.innerHTML=''
   return true
}

const formLogin= document.querySelector('[value="登入"]')
const formSingup= document.querySelector('[value="註冊"]')


formLogin.addEventListener('click',function(e){
   if(!verifyName()) e.preventDefault()
   if(!verifyPasswordName()) e.preventDefault()   


   if(verifyName()&&verifyPasswordName()){
      alert('登入成功')
        username.innerHTML=""
        password.innerHTML=""
        localStorage.setItem('uname',username.value)
        location.href="./index.html"
   }
})
formSingup.addEventListener('click',function(e){
   if(!verifyNewName()) e.preventDefault()
   if(!verifyNewPasswordName()) e.preventDefault()
   if(!verifyComfirmPasswordName()) e.preventDefault()
   if(verifyNewName()&&verifyNewPasswordName()&&verifyComfirmPasswordName()){
      alert('註冊成功')
      // newUsername.innerHTML=""
      // newPassword.innerHTML=""
      // comfirmPassword.innerHTML=""
      location.href="./login.html"
   }
})

export default{
   showpage,
   verifyName
}





