<template>
    <div class="page">
          <form class="info">
            <div class="dateStoE" >
                <label>開始日期 </label>
                    <input type="date" id="start" name="trip-start"
                    v-model="begin" @change="datechange()">
                <label>~ 結束日期 </label>
                    <input type="date" id="start" name="trip-start"
                    v-model="end" @change="datechange()">
                    </div>
              <!-- 狀態：<select name="city" class="city">
                  <option value=""></option>
                  <option value=""></option>
                  <option value=""></option>
                  <option value=""></option>
                  <option value=""></option>
              </select> -->
              <input type="button" class="button"  @click="search" @keyup.enter="search" value="查詢">
        
          </form>
  
          <table class="table">
              <thead>
                  <tr>
                      <th>商品單價</th>
                      <th>商品數量</th>
                      <th>商品名稱</th>
                      <th>訂單總價</th>
                      <th>訂單完成日期</th>
                  </tr>
              </thead>
              <tbody  @click="stop($event,item.userIdBuyer)" v-for="item in list" :key="item.userIdBuyer">
                  <tr>  
                      <td>{{item.orderProductUnitPrice}}</td>
                      <td>{{item.orderProductQuantity}}</td>
                      <td>{{item.orderProductItem}}</td>
                      <td>{{item.productTotal}}</td>
                      <td>{{item.productPlacementTime}}</td>
                  </tr>
  
              </tbody>
              
          </table>
          <div class="footer">
            <div class="pagenum">
            <span class="spanp">當前頁面顯示 : </span>
            <select class="pageas" v-model="pageSize" @change="onChange">
              <option value="10" >10</option>
              <option value="20" >20</option>
              <option value="30" >30</option>                                 
            </select>
          </div>
          
          <span class="spanpage">總共{{total}}筆資料</span>
          <div class="pages">
              <ul class="pagination">
                  <li :class="page<=1?'disabled':''"  @click="prePage($event)"><a href="#">«</a></li>
                  <li v-for="pageTotal in pageTotals" :key="pageTotal" ><a href="#" :class="{'active': (page === (pageTotal))}" @click="curPage($event,pageTotal)">{{pageTotal}}</a></li>
                  <li :class="page>=1?'disabled':''" @click="nextPage($event)"><a href="#">»</a></li>
              </ul>
          </div>
          </div>                
    </div>
  </template>
  
  <script>
  import axios from 'axios'
  export default {
      name:'OrderProductListPage'
      ,
      data(){
        return{
          list:[],
          itemList:[],
          begin:'',
          end:'',
          page:1,
          pageSize:10,
          pageTotals:[],
          total:1,
          userId:1
        }
      },methods:{ 
        getPage(i){
          if(i){
              this.page=i  
          }else{
              this.page=1             
          }
          const uid = localStorage.getItem('uid')
          this.userId=uid
  
          axios.get(`http://localhost:8005/homie-demo/searchOrderProduct/${this.userId}?page=${this.page}&pageSize=${this.pageSize}`,{params:{
            begin:this.begin,
            end:this.end
          }}).then(res =>{          
             this.list =  res.data.data.rows
             this.total = res.data.data.total
             this.pageTotals = Math.ceil(res.data.data.total/this.pageSize);
            })   
       },
        curPage(e,pageTotal){
          e.preventDefault()
        this.getPage(pageTotal);
        },
        prePage(e){
          e.preventDefault()
          if(this.page>1){
          this.page--;
          this.getList(this.page);
          } 
        },nextPage(e){
          e.preventDefault()
          if(this.page<this.pageTotals){
          this.page++;
          this.getList(this.page);
          }
        },onChange(){	
          this.search()
          this.page=1;		
          this.getList();
          },
        
        search(){
            this.getPage()
          },datechange(){
            new Date(this.begin);
            new Date(this.end);
         }
      },mounted(){
          this.getPage()
        
      }
  }
  </script>
  
  <style scoped>
  #start{
    width: 100px;
  }
  .footer{
    margin-top:-35px;
  }

  .dateStoE{
    display: flex;
    margin-left:100px ;
  }
  .dateStoE label{
    line-height: 25px;
    margin-right: 10px;
  }
  .table{
    margin-bottom: 20px;
  }
  .spanpage{
    position: absolute;
    left: 55px;
    bottom: 35px;
    font-size: 13px;
    color:#565656;
  }
  .pageas{
    font-size: 13px;
  }
  .spanp{
    font-size: 13px;
    color:#565656;
  }
  .pagenum{
    position: absolute;
    right: 55px;
    bottom: 35px;
    z-index: 1;
  }
  .button{
    position: absolute;
    right: 60px;
    top:30px;
    color: white;
    background-color:#1085bc;
  }
  .pages{
    position: relative;
    width:auto;
    bottom: 10px;
    right: 20px;
    margin: 10px 0;
    text-align: center;
    margin-top: 70px;
  }
  ul.pagination {
    display: inline-block;
    padding: 0;
    margin: 0;
  }
  
  ul.pagination li {display: inline;}
  
  ul.pagination li a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
  }
  
  ul.pagination li a.active {
    background-color: #1085bc;
    color: white;
  }
  
  ul.pagination li a:hover:not(.active) {
    background-color: #ddd;
  }
  .page{
      margin-top:-50px;
  }
  
  table {
    margin:0 auto;
    width: 600px;
    border-collapse: collapse;
    color:#004085;
  }
  th {
    padding: 5px;
    background: #cfe5ff;
    
    font-size: 12px;
    font-weight: 400;
  }
  td,th {
    border:1px solid #b8daff;
  }
  td {
    padding:10px;
    color:#666;
    text-align: center;
    font-size: 12px;
  }
  tbody tr {
    background: #fff;
    font-size: 12px;
  }
  tbody tr:hover {
    background: #e1ecf8;
  }
  .info {
    width: 600px;
    margin: 30px auto;
    text-align: center;
    font-size: 12px;
  }
  .info  input, .info select {
    width: 80px;
    height: 27px;
    border-radius: 5px;
    border:1px solid #b8daff;
    padding-left: 5px;
    box-sizing: border-box;
    margin-right: 15px;
  }
  .info button {
    width: 60px;
    height: 27px;
    background-color:#1085bc;
    border: 0;
    color: #fff;
    cursor: pointer;
    border-radius: 5px;
  }
  .info .age {
    width: 50px;
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