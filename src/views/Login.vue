<template>
    <div>

        <div id="title">叮当快购抢购系统</div>
        <br>
        <br>
        <div id="login">
            <el-form><el-form-item>
        登录名：<el-input v-model="loginForm.username" placeholder="请输入内容" ></el-input></el-form-item>
        
        <el-form-item>密&nbsp;&nbsp;&nbsp;&nbsp;码：<el-input v-model="loginForm.userpass" placeholder="请输入内容"></el-input></el-form-item>
        
        
        
        <el-button type="info" plain @click="loginbutton('loginForm')">登录</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
        <el-button type="info" plain @click="resetbutton">重置</el-button>

        </el-form>
        <br>
        <router-link to="/Jpg">折线图</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link to="/JpgBing">饼图</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        <router-link to="/JpgZhu">柱状图</router-link>
        <br>
        <router-link to="/TianDi">天干地支</router-link>&nbsp;&nbsp;&nbsp;&nbsp;
        
        </div>
    

    </div>

</template>

<script>
export default {
    name: 'Login',

    data() {
        return {
            loginForm:{
                username:"",
                userpass:"",
            }
            
        };
    },

    mounted() {
        
    },

    methods: {
        loginbutton(loginForm){
            this.$axios
            .post("http://127.0.0.1:9999/cardGameUser/loginNew", this.loginForm)
            .then((response) => {
              if (response.data.code == 200) {
                //页面跳转
                this.$message("登录成功");
                this.$router.push("/Main");
              } else {
                this.$message.error("账号或者密码错误");
              }
            });
        },
        
    
      
           
        resetbutton(){
            this.loginForm.username = "";
            this.loginForm.userpass = "";
        },
        
    },
};
</script>

<style lang="scss" scoped>
#title{
    font-size: 50px;
    color:blue;
    text-align: center;
}

.el-input {

      width: 300px;
      height: 50px;

    }
    #login{
        margin-left: -10px;
    }
</style>