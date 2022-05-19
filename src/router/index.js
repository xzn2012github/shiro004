import Vue from 'vue'
import VueRouter from 'vue-router'
// import HomeView from '../views/HomeView.vue'
import Login from '../views/Login.vue'
import Main from '../views/Main.vue'
import MyInfo from '../views/MyInfo.vue'
import CardGameList from '../views/CardGameList.vue'
import CardProductList from '../views/CardProductList.vue'
import Jpg from '../views/Jpg.vue'
import JpgBing from '../views/JpgBing.vue'
import JpgZhu from '../views/JpgZhu.vue'
import TianDi from '../views/TianDi.vue'
import FiveGo from '../views/FiveGo.vue'
import BuildWeb from '../views/BuildWeb.vue'
import BuildWebNew from '../views/BuildWebNew.vue'



Vue.use(VueRouter)



const routes = [{
        path: '/',
        name: 'Login',
        component: Login
    }, {
        path: '/Main',
        name: 'Main',
        component: Main,
        children: [{
                path: 'MyInfo',
                name: 'MyInfo',
                component: MyInfo

            }, {
                path: 'CardGameList',
                name: 'CardGameList',
                component: CardGameList

            }, {
                path: 'CardProductList',
                name: 'CardProductList',
                component: CardProductList

            }

        ]
    }, {
        path: '/Jpg',
        name: 'Jpg',
        component: Jpg
    }, {
        path: '/JpgBing',
        name: 'JpgBing',
        component: JpgBing
    }, {
        path: '/JpgZhu',
        name: 'JpgZhu',
        component: JpgZhu
    }, {
        path: '/TianDi',
        name: 'TianDi',
        component: TianDi,
        children: [{
            path: 'FiveGo',
            name: 'FiveGo',
            component: FiveGo
        }]
    }, {
        path: '/BuildWeb',
        name: 'BuildWeb',
        component: BuildWeb
    }, {
        path: '/BuildWebNew',
        name: 'BuildWebNew',
        component: BuildWebNew
    }
    // {
    //   path: '/about',
    //   name: 'about',
    //   // route level code-splitting
    //   // this generates a separate chunk (about.[hash].js) for this route
    //   // which is lazy-loaded when the route is visited.
    //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
    // }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BASE_URL,
    routes
})

export default router