<template>
  <div>
    <main>
        <div class="mainbox">
            <div class="box1">
                <ul class="boxul">
                    <li><router-link to="/information">會員資料</router-link></li>
                    <li><router-link to="/orderlist">銷售訂單記錄</router-link></li>
                    <li><router-link to="/orderProductlist">商品訂單記錄</router-link></li>
                    <li><router-link to="/chart">圖表資料</router-link></li>
                </ul>
            </div>
            <div class="box2">
                <div class="box2in">
                    <router-view></router-view>                
                </div>
                
            </div>
        </div>
    </main>
  </div>
</template>

<script>
export default {
    name:'MemberPage'
}
</script>

<style scoped>
.box1 ul li a.router-link-active{
   color: white; 
}
li a.router-link-active{
    background-color: #1085bc; 
}
nav>ul{
    display:flex ;
    list-style-type: none;
    justify-content: space-around;
    margin-right: 1.5rem;
}
.box1 ul{
    display:flex ;
    list-style-type: none;
    justify-content: space-around;
    margin-right: 1.5rem;
}

.box1 ul li a{
    color: rgb(100, 112, 127);
    text-decoration: none;
    font-size: 1rem;
}
.logo .cleantx{
    color: rgb(100, 112, 127);
    text-decoration: none;
    font-size: 1rem;
}

nav{
    flex:3 1 300px;
}

@media screen and (max-width :850px) {
    .imglogo{
        width: 10vw;
        height: 10vw;
    }
}
.container{
  padding: 10px;
  width: 350px;
  height: 400px;
  background-color: white;
  border-radius: 5px;
  border-top: 20px solid #e5e5e5;
  box-shadow: 0 0px 70px rgba(0, 0, 0, 0.1);
  

  position:relative;   
  margin: auto;
  top: 150px;
  text-align:center;  
}
a.aa:hover {
    color: #1085bc;
   }

.mainbox{
    display: flex;
    width:900px ;
    height: auto;
    /* border:1px solid #cccccc; */
    border:none;
    position:relative;   
    margin: auto;
    top: 130px;
    text-align:center
}
.box1{
    width: 200px;
    height: 500px;
    background-color: #f5f5f5;
    border-radius: 5px;
}
.box1>ul{
    display: flex;
    flex-direction:column;
    width: 100%;
    padding: 0;
}
.box1 >ul >li >a{
    display: inline-block;
    /* border: 1px solid rgb(223, 223, 223); */
    width: 100%;
    padding: 8px 12px;
    text-decoration: none;
    font-size: 0.85rem;
}


/* .box1 >ul >li:first-child{
    background-color: #2d6fba;
}
.box1 >ul >li:first-child a{
    color: #fff;
} */
.box2{
    position: relative;
    width: 900px;
    height: auto;
    background-color: #f5f5f5;
    border: none;
    margin-left: 30px;

}
.box2in div:nth-child(1){
    padding-top: 50px;
}
.box2in>div{
    padding-top: 15px;
}
label {
    font-size: 12px;
}

.sub{
    width: 75px;
    height: 25px;
    background-color: #a4a4a4;
    border:1px solid #ffffff;
    margin:0 15px ;
    margin-top: 100px;
    cursor: pointer;
    color: #ededed;
    border-radius: 5%;
    margin-left: 25px;
}
.sub:hover{
    background-color: #1085bc;
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