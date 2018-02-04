import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Slice from '@/modules/jslib/Slice'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/slice',
      name: 'Slice',
      component: Slice
    }, {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    }
  ],
  mode: 'history'
})
