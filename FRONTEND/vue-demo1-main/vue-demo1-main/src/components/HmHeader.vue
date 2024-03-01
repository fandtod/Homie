<template>
  <div class="Hm-Header">
    <div class="logo">
            <a href="#/home"><img class="imglogo" src="../assets/images/—Pngtree—homestay house logo_5396744.png"
                    alt="logo" /></a>
            <a href="#/home">
                <h1>Clean House</h1>
            </a>
    </div>
  
        <nav class="headernav"  v-if="isuname">
          <ul class="list">
              <li class="head"><a class="aa" style='color: rgb(100, 112, 127);position: relative;
             right:80px ;' href="#">{{uname}}</a></li>
                <li><a style="display:none;" class="aa" href="#/login">註冊登入</a></li>
                <li><router-link class="aa" to="/about">關於我們</router-link></li>
                <li><router-link class="aa" to="/store">賣場</router-link></li>
                <HmCart v-if="refresh"></HmCart>
                <li><a class="aa" style='color: rgb(100, 112, 127);' href="#/information">會員專區</a></li>               
            </ul>          
            <span  class="logout" style="display:block;"  @click="logout">登出</span>
        </nav>
       
        <nav class="headernav" v-else  > 
          <ul class="list">
              <li><a class="aa" href="./index.html"></a></li>
              <li><router-link class="aa" to="/login">註冊登入</router-link></li>
                <li><router-link class="aa" to="/about">關於我們</router-link></li>
                <li><router-link class="aa" to="/store">賣場</router-link></li>
                <HmCart v-if="refresh"></HmCart>
            </ul>
            <span else class="logout"   @click="logout"></span>    
          
          
        </nav>

        
        
       
  </div>

</template>

<script>
import Bus from '@/utils/EventBus'
export default {
  data(){
    return{
     refresh:true,
     uname:"",
     isuname:true
    }
  },mounted(){
    Bus.$on('refresh',(data)=>{
      this.refresh=false
      this.$nextTick(()=>{
        this.refresh=data
      })
      
    })
    
  },methods:{
    getName(){
      if(localStorage.getItem('uname')!=null){
        this.isuname=true
      }else{
        this.isuname=false
      }
    },
    logout(){
      localStorage.removeItem('uname');
      this.render()
      localStorage.removeItem('uid');
      this.$router.push('/login');
      setTimeout(function(){
        window.location.reload();
      },0)
      
    }
    
},created(){
  this.getName()
}
  }

</script>

<style scoped>
*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
h1,h2,h3,h4,h5,h6{
  font-weight: normal;
  font-size: 1rem;
}
body::-webkit-scrollbar {
  display: none;
}
.logout{
  position: absolute;
  right:455px;
  top:28px;
  cursor: pointer;
  color: rgb(100, 112, 127);
  text-decoration: none;
  font-size: 1rem;
}
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
.aa{
  cursor: pointer;
}
.aa:hover {
    color: #1085bc;
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
}
.imglogo{
    width: 5vw;
    height: 5vw;
}

.Hm-Header>.headernav>ul{
    display:flex ;
    list-style-type: none;
    justify-content: space-around;
    margin-right: 1.5rem;
}
.Hm-Header>.headernav>ul>li>a,.Hm-Header>.logo>a{
    color: rgb(100, 112, 127);
    text-decoration: none;
    font-size: 1rem;
}
.Hm-Header>.headernav>ul>li>a:hover{
    color: #1085bc;
}
.headernav{
    flex:3 1 300px;
}

@media screen and (max-width :850px) {
    .imglogo{
        width: 10vw;
        height: 10vw;
    }
}



</style>