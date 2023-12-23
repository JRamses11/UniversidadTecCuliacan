import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import Maestros from '../views/Maestros.vue'
import Detalle from '../components/Detalle.vue'
import Editar from '../components/Editar.vue'
import Nuevo from '../components/Nuevo.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: '/maestros',
    name: 'maestros',
    component: Maestros
  },
  {
    path: '/detalle',
    name: 'detalle',
    component: Detalle,
    props: true
  },
  {
    path: '/editar',
    name: 'editar',
    component: Editar,
    props: true
  },
  {
    path: '/nuevo',
    name: 'nuevo',
    component: Nuevo
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: function () {
      return import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
