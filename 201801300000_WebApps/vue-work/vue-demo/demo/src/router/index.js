import Vue from 'vue'
import Router from 'vue-router'
import Slice from '@/modules/jslib/Slice'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Slice',
      component: Slice
    }
  ]
})
