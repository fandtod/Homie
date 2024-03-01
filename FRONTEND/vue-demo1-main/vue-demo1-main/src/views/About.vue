<template>
  <div>
    <main>
        <div class="container">
            <div class="containerimg">
                <img src="../assets/images/about.jpg" alt="">
            </div>
            <div class="containertext">
                <h3>品牌介紹</h3>
                <p>
                    有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字，目前本品牌介紹還在思考當中，先寫一些不必要的文字有關清潔相關知識請查閱此處，目前本品牌介紹還在思考當中，先寫一些不必要的文字
                </p>
            </div>
        </div>

        <div class="container2">
            <div class="wrap">
                <div class="cblock">
                    <span></span>
                </div>
                <div class="cblock">
                    <img src="../assets/images/about.jpg" alt="">
                </div>
                <div class="cblock">
                    <span></span>
                </div>
                <div class="cblock">
                    <img src="../assets/images/about.jpg" alt="">
                </div>
            </div>
            <div class="wrap">
                <div class="cblock">

                    <img src="../assets/images/about.jpg" alt="">

                </div>
                <div class="cblock">
                    <span></span>
                </div>
                <div class="cblock">

                    <img src="../assets/images/about.jpg" alt="">

                </div>
                <div class="cblock">
                    <span></span>
                </div>
            </div>
        </div>
        <HmFooter></HmFooter>
    </main>
  </div>
</template>

<script>
import HmFooter from '../components/HmFooter.vue'
export default {
    name:'AboutPage',
    components:{
        HmFooter
    }
}
</script>

<style scoped>
.container{
    width: 600px;
}

.container{
    padding: 10px;
    width: 90%;
    height: 525px;
    background-color: white;
    border-radius: 5px;
    box-shadow: 0 0px 70px rgba(0, 0, 0, 0.1);
    border-top: white;
    
  
    position:relative;   
    margin: auto;
    top: 150px;
    text-align:center;  
    display: flex;
  }
  .container img{
    position: relative;
    height: 500px;
    width: 800px;

  }
  .containertext{
    margin-left: 10px;
    width: 1000px;
  }
  .container h3{
    font-size: 32px;
    color: #464646;
  }
  .container p{
    font-size: 16px;
    color: #848484;
    padding: 0 20px;
    text-align: left;
    line-height: 24px;
    letter-spacing: 3px;
    margin-left: 5px;
  }
  .container2{
    padding: 10px;
    width: 100%;
    
  
    position:relative;   
    margin: 100px 0;
    top: 150px;
  }
  .wrap{
    width: 90%;
    margin: auto;
    display: flex;
    align-items: center;
  }
.cblock{
    width: 90%;
    height: 250px;

    margin: 10px 10px;
    text-align: center;
    line-height: 230px;
    background-color: #8dbbc4;
  }
  .cblock img{
    width: 100%;
    height: 250px;
  }
  .wrap .cblock span{
    color: #fff;
    font-size: 18px;
  }

  .last{
    margin-top: 200px;
    min-height: 40vh;
    background-color: #2c262a;
}
.last1{
    padding-top: 2rem;
    padding-left: 8rem;
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
}
.p1{
    color: white;
    font-size: 1rem;
    font-weight: lighter;
    padding: 0.25rem;
}
</style>