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
    <div class="box">
        <div class="main">
            <img class="img" src="../assets/images/start.png" alt="">
            <span>訂單完成</span>
            <div class="btnbox">
                <router-link class="aa" to="/home"><button>返回首頁</button></router-link>
            </div>
            <div class="btnbox">
                <router-link class="aa" to="/information"><button>返回會員</button></router-link>
            
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
    name:"CheckOutPageEnd"
}
</script>

<style scoped>
.main span {
    position: absolute;
    color: #858585;
    font-size: 18px;
    right: 730px;
    top: 320px;
}
.img{
    position: absolute;
    width: 180px;
    height: 180px;
    top:130px;
    left: 680px;

}
.btnbox{
    padding: 10px;
}
.btnbox button{
    width: 100px;
    background-color: #3daaa5;
    border : 1px solid #cecece;
    padding: 3px 10px;
    color: #ffffff;
    cursor: pointer;
    margin: 0 10px;
}
.main{
  display: flex;
  align-items: center;
  margin: 0 auto;
  margin-top:230px ;
}
.box{
    width: 600px;
    height: 200px;
    display: flex;
    margin: 0 auto;
    margin-top: 150px;
   
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