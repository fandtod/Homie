<template>
  <div>
    <main>
    <section class="backImage">
      <div class="filter"></div>
      <h3>立即開始訂購服務以及查看所有優惠方案</h3>
      <a class="start" href="#/store">立即訂購</a>
    </section>
  </main>
  <section class="second">
    <h2>選擇方案</h2>

    <section class="cards">
      <div class="card">
        <img class="img2" src="../assets/images/veer-374710520.jpg" alt="">
        <h4>快速配對</h4>
        <p>選擇方案一享有最快速的服務品質保證，由專業人員到府清潔，月月只要9999元即可獲得優惠券100元折抵</p>
        <a class="a2" href="#">方案一</a>
      </div>
      <div class="card">
        <img class="img2" src="../assets/images/cleaning-mop-and-bucket.jpg" alt="">
        <h4>快速配對</h4>
        <p>選擇方案二享有最快速的服務品質保證，由專業人員到府清潔，月月只要9999元即可獲得優惠券100元折抵</p>
        <a class="a2" href="#">方案二</a>
      </div>
      <div class="card">
        <img class="img2" src="../assets/images/images.jpg" alt="">
        <h4>快速配對</h4>
        <p>選擇方案三享有最快速的服務品質保證，由專業人員到府清潔，月月只要9999元即可獲得優惠券100元折抵</p>
        <a class="a2" href="#">方案三</a>
      </div>


    </section>
  </section>
  <section class="third">

    <h2>服務項目</h2>
    <section class="card3">
      <div class="card">
        <img class="img2" src="../assets/images/veer-374710520.jpg" alt="">
        <h4>快速配對</h4>
        <p>選擇方案一享有最快速的服務品質保證，由專業人員到府清潔，月月只要9999元即可獲得優惠券100元折抵</p>
        <a class="a2" href="#">方案一</a>
      </div>

    </section>

  </section>

  <div class="fourth">

    <div class="img4">
      <img src="../assets/images/mop.jpg" alt="">
    </div>
    <div class="fourthtext">
      <h3>清潔科普</h3>
      <p>
        有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字，目前本品牌介紹還在思考當中，先寫一些不必要的文字有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字
      </p>
      <a href="#/about">查看更多</a>
    </div>
    <HmFooter></HmFooter>
  </div>
  </div>
</template>

<script>
import HmFooter from '../components/HmFooter.vue'
export default {
    name:'HomePage',
    components: {
    HmFooter
  },mounted(){
    this.render()
  }
}
</script>

<style>
*{
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
body::-webkit-scrollbar {
  display: none;
}
.backImage{
    width: 100%;
    min-height: 100vh;
    background-image: url(../assets/images/house.jpg);
    background-size: cover;
    background-position: center;
    position: relative;
    z-index: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
    text-align: center;
}
.filter{
    background-color: rgba(0,0,0,0.2);
    width: 100%;
    min-height: 100vh;
    position: absolute;
    top: 0;
    z-index: -1;
}
.start{
    background-color: rgb(19, 87, 159);
    padding: 0.75rem 1.5rem;
    font-size: 1.25rem;
    color: white;
    border: none;
    border-radius: 1rem;
    cursor: pointer;
}

.second{
    min-height:100vh ;
    display: flex;
    flex-direction: column;
    align-items: center;
}
h2{
    font-size: 1.75em;
    margin: 4rem 0  ;
    color: rgb(144, 143, 143) ;
}
.cards{
    display: flex;
    width: 90%;
    height: 80vh;
    margin-top: 0.5rem;
}
.card{
border: 0.5px solid rgb(216, 216, 216);
display: flex;
flex-direction: column;
align-items: center;
padding: 2rem;
margin: 0 1rem;
box-shadow: 0 0 15px 10px #ececec;

}
h4{
    font-size: 1.25rem;
    color: rgb(105, 105, 105);
    padding-bottom: 1rem;
}
p{
    font-size: 0.85rem;
    color: rgb(150, 150, 150);
    text-align: justify;
}
.img2{
    width: 20vw;
    height: 20vw;
}
.a2{
    text-decoration: none;
    padding: 0.5em 1.25rem;
    margin-top: 1.5rem;
    background-color: #1085bc;
    color: white;
    border-radius: 5px;
}
.card3{
    width: 90%;
    align-items: center;
    justify-content: center;
}
.img4{
    width: 100%;
    height: 20vw;
}
.third{
    min-height:100vh ;
    display: flex;
    flex-direction: column;
    align-items: center;
}
.imgs{
    min-height: 80vh;

}
.h2back{
    color: white;

}
.imgstyle{
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: rgb(173, 173, 173);

}

h5{
   color: #1085bc; 
   font-size: 2rem;
   padding: 1rem;
}


h6{
    color: white;
    font-weight: lighter;
    font-size: 0.5rem;
    display: flex;
    align-items: center;
    justify-content: center;
    margin-top: 2rem;
}
iframe{
    margin-bottom: 5rem;
}
a.aa:hover {
 color: #1085bc;
}
.fourth{
    display: flex;
    flex-wrap: wrap;
    margin-top: 100px;
    height: 500px;

}
.fourth .fourthtext a{
    display: inline-block;
    width: 100px;
    height: 35px;
    background-color: #1085bc;
    text-align: center;
    line-height: 35px;
    color: #ececec;
    margin-top: 100px;
    margin-left: 480px;
}
.fourthtext{
    position: absolute;
    margin-left: 450px;
    text-align: left;
    width: 580px;    
    right:200px;
}
.fourthtext h3{
    color: #464646;
    margin-left: 0;
    font-size: 30px;
}
.fourthtext p{
   font-size: 16px;
   text-align: justify;
   line-height: 24px;
   letter-spacing: 3px;
}
.img4 img{
    height: 500px;
    width: 600px;
    padding-left: 100px;
}
@media screen and (max-width :1300px) {
    .fourthtext{
    margin-left: 480px;
    width: 380px;    
}
.fourth .fourthtext a{
    display: inline-block;
    width: 100px;
    height: 35px;
    background-color: #1085bc;
    text-align: center;
    line-height: 35px;
    color: #ececec;
    margin-top: 100px;
    margin-left: 280px;
}
}

@media screen and (max-width :1085px) {
    

}
.backImage>h3{
  font-size: 26px;
  font-weight: 500;
  color: white;
  padding-bottom: 30px;
}
</style>