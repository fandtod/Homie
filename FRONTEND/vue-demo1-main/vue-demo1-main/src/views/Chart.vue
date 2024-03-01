<template>
  <div class="chart">
    <highcharts :options="chartOptions" :callback="myCallback"></highcharts>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  name: "ChartPage",
  data() {
    return {
      userId:1,
      chartOptions: {
        chart: {
        type: 'line'
    },
    title: {
        text: []
    },
    subtitle: {
        text: '' 
    },
    xAxis: {
        categories: []
    },
    yAxis: {
        title: {
            text: ''
        }
    },
    plotOptions: {
        line: {
            dataLabels: {
                enabled: true
            },
            enableMouseTracking: false
        }
    },
    series: [{
        name: 'Reggane',
        data: []
    }]
      }
    };
  },methods:{
      linecharts(){
      axios.get(`http://localhost:8005/homie-demo/year/${this.userId}`).then((resp)=>{
          this.chartOptions.xAxis.categories=resp.data.data.months   
          this.chartOptions.series[0].data=resp.data.data.totalprice  
          this.chartOptions.title.text=resp.data.data.years +'年 月平均金額'
          console.log(resp.data.data.months)
          })
        },myCallback() {
      console.log("this is callback function");
    }
      },
      mounted() {
          this.linecharts()
          const uid = localStorage.getItem('uid')
          this.userId=uid
      }
};
</script>

<style scoped>
.chart{
  width: 600px;
  display: flex;
  align-items: center;
  margin: 0 auto;
}
</style>