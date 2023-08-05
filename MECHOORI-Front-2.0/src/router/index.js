import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'

import AdminDashboard from '../views/admin/Dashboard.vue'
import AdminLayout from '../components/admin/Layout.vue'
import AdminMember from '../views/admin/Member.vue'
import AdminRestaurant from '../views/admin/Restaurant.vue'
import RestaurantAdd from '../views/admin/restaurant/Add.vue'
import RestaurantEdit from '../views/admin/restaurant/Edit.vue'


import '@/assets/css/reset.css'
import '@/assets/css/style.css'
import '@/assets/css/util.css'
import '@/assets/css/common/icon.css'
import '@/assets/css/common/form.css'
import '@/assets/css/common/button.css'
import '@/assets/css/admin/style.css'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      // Component를 직접 import하여 routing 하는 방식
      // Application을 처음 로드할 때 이 component가 함께 로드됨
      // 따라서 초기 로딩 시간이 늘어남
      // 그러므로 자주 방문되는 View 혹은 크기가 작은 View에 적합함
      component: Home
    },
    {
      path: '/admin',
      name: 'admin',
      component: AdminLayout,
      children: [
        { path: 'dashboard', component: AdminDashboard },
        { path: 'member', component: AdminMember },

        { path: 'restaurant', component: AdminRestaurant},
        { path: 'restaurant/add', component: RestaurantAdd },
        { path: 'restaurant/edit/:id', component: RestaurantEdit },
        
        { path: 'category', component: AdminMember },
      ]
    }
  ]
})

export default router
