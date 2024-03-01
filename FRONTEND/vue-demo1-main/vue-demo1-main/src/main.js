import Vue from 'vue'
import App from './App.vue'
import router from './router/index'
import HmCart from './components/HmCart'
import HmCartDetail from './components/HmCartDetail'
import render from '@/operatejs/rank'
import Axios from 'axios'
import Highchart from "highcharts/highcharts";
import HighchartsVue from 'highcharts-vue'
import stockInit from "highcharts/modules/stock";


Vue.prototype.$axios = Axios
Axios.defaults.baseURL = '/api'
Axios.defaults.headers.post['Content-Type']='application/json'

Vue.use(render)
Vue.use(HighchartsVue)
stockInit(Highchart);
Vue.config.productionTip = false
Vue.component('HmCart',HmCart)
Vue.component('HmCartDetail',HmCartDetail)

new Vue({
  render: h => h(App),
  router:router
}).$mount('#app')


