<template>
    <div>
         
         
        
        <div id="title">欢迎来到叮当快购！</div>
        <br>
        <br>
        <router-link to="/BuildWeb">建站</router-link>
        <br>
        <router-link to="/BuildWebNew">建站1</router-link>
        <br>
        <router-link to="/Main/MyInfo"><el-link type="primary" >查看个人信息</el-link></router-link>
        <br>
        <router-link to="/Main/CardGameList"><el-link type="primary">查看活动列表</el-link></router-link>
        <br>
        <router-link to="/Main/CardProductList"><el-link type="primary">查看奖品列表</el-link></router-link>

        <h1>文件上传</h1>

    <form action="http://127.0.0.1:9999/upload/file" id="uploadform" enctype="multipart/form-data" method="post">
        <input name="dir" value="filedir">
        <input name="file" type="file" multiple @onchange="toupload" accept="image/jpg">
    </form>

        <router-view></router-view>
    </div>

   
</template>

<script>
export default {
    name: 'Main',

    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        toupload(){
            document.getElementById("uploadform").submit();
        }
        
    },
};
</script>

<style lang="scss" scoped>
#title{
    font-size: 50px;
    color:blue;
    text-align: center;
}

</style>