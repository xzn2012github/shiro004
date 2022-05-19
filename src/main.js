import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import axios from 'axios'
import 'element-ui/lib/theme-chalk/index.css'
import FileSaver from 'file-saver'
import XLSX from 'xlsx'
import CKEditor from 'ckeditor4-vue';
import VueUeditorWrap from 'vue-ueditor-wrap'
Vue.component('vue-ueditor-wrap', VueUeditorWrap)


Vue.use(VueUeditorWrap);
Vue.use(CKEditor);
Vue.use(ElementUI)


Vue.config.productionTip = false
Vue.prototype.$axios = axios
axios.defaults.withCredentials = true;
new Vue({
    router,
    store,
    render: h => h(App)
}).$mount('#app')