

export default {
   install(Vue){
      Vue.prototype.render = function (){
         // const li1 = document.querySelector('nav li:first-child')
         //  const li2 = document.querySelector('nav li:nth-child(2)')
         //  const li6 = document.querySelector('nav li:nth-child(6)')
         //  const span = document.querySelector('.logout')
         //   const uname = localStorage.getItem('uname')
         // if(uname){
         //    li1.innerHTML=`<li class="head"><a class="aa" style='color: rgb(100, 112, 127);position: relative;
         //    right:80px ;' href="#">${uname}</a></li>`
         //    li2.innerHTML='<li style="display:none;"><a style="display:none;" class="aa" href="#/login">註冊登入</a></li>'
         //    li6.innerHTML=`<li><a class="aa" style='color: rgb(100, 112, 127);' href="#/information">會員專區</a></li>`
         //    span.innerHTML='<span class="logout" style="display:block;"  @click="logout">登出</span>'
         // }else{
         //    li1.innerHTML='<li><a class="aa" href="./index.html"></a></li>'
         //    li2.innerHTML=`<li><a class="aa" style="display:block;color: rgb(100, 112, 127);" href="#/login">註冊登入</a></li>`
         //    li6.innerHTML='<li><a class="aa" href="./store.html"></a></li>'
         //    span.innerHTML='<span class="logout"  @click="logout"></span>'
         // }


         // const data = [
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(100, 67, 68)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(43, 35, 26)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(36, 31, 33)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(139, 98, 66)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(67, 90, 92)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(166, 131, 143)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(53, 29, 25)' },
         //    { url: './image/house.jpg', title: '這是房子', color: 'rgb(99, 72, 114)' },
         //  ]
         //  const img = document.querySelector('.slider-wrapper img')
         //  const p = document.querySelector('.slider-footer p')
         //  const footer = document.querySelector('.slider-footer')
         //  const next = document.querySelector('.next');
         //  const prev = document.querySelector('.prev');
         //  const imgli = document.querySelectorAll('.slider-indicator li');
        
         //  let i = 0;
         //  next.addEventListener('click', function () {
         //    i++
         //    i = i >= this.data.length ? 0 : i
         //    toggle()
         //  })
         //  prev.addEventListener('click', function () {
         //    i--
         //    i = i < 0 ? this.data.length - 1 : i
         //    toggle()
         //  })
         //  for(let i=0;i<imgli.length;i++){
         //    imgli[i].addEventListener('click',function(){
         //      img.src = this.data[i].url
         //      p.innerHTML = this.data[i].title
         //      footer.style.backgroundColor = this.data[i].color
         //      document.querySelector('.slider-indicator .active').classList.remove('active')
         //      document.querySelector(`.slider-indicator li:nth-child(${i + 1})`).classList.add('active')
         //    })
         //  }
          
         //  function toggle() {
         //    img.src = this.data[i].url
         //    p.innerHTML = this.data[i].title
         //    footer.style.backgroundColor = this.data[i].color
         //    document.querySelector('.slider-indicator .active').classList.remove('active')
         //    document.querySelector(`.slider-indicator li:nth-child(${i + 1})`).classList.add('active')
         //  }
         //  let timeId = setInterval(function () {
         //    next.click()
         //  }, 3000)
         //  const slider = document.querySelector('.slider')
         //  slider.addEventListener('mouseenter', function () {
         //    clearInterval(timeId)
         //  })
         //  slider.addEventListener('mouseleave', function () {
         //    clearInterval(timeId)
         //    timeId = setInterval(function () {
         //      next.click()
         //    }, 3000)
         //  })
        
          
         //  const pagea = document.querySelectorAll('.pagination a')
        
         //  for(let i=1;i<pagea.length-1;i++){
         //    pagea[i].addEventListener('click',function(){
         //        document.querySelector('.pagination .active').classList.remove('active')
         //        document.querySelector(`.pagination li:nth-child(${i+1}) a`).classList.add('active')
         //    })
         //  }



      }
   }
}