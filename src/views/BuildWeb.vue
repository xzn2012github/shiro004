<template>
    <div>
        <router-link to="/Main"><div id="webManage" >网站管理</div></router-link>
        <br>
        <div id="title" ref="text" @click="check" @input="changeDivText($event)">{{this.title}}</div>
        <div id="buy">购买升级</div>
        <div id="save"><el-button type="primary" plain @click="save">保存</el-button></div>
        <div id="look"><el-button type="primary" plain @click="look">预览</el-button></div>
        <div id="cacle"><el-button type="primary" plain @click="cacle">取消</el-button></div>
        <br>
        <br>
        <div id="index">首页</div>
        <div id="say">留言板</div>
        <div id="aboutOur">关于我们</div>
        <div id="withOur">联系我们</div>
<br>
<br>
        <el-button type="success" round id="module" @click="clickModule" v-show="stateModule">模块</el-button>
        <el-button type="success" round id="style" @click="clickStyle" v-show="stateStyle" >样式</el-button>
        <el-button type="success" round id="set" @click="clickSet" v-show="stateSet">设置</el-button>
        <el-button type="success" round id="improve" @click="clickImprove" v-show="stateImprove">百度优化</el-button>

        <img id="pig" src="../assets/模板.jpg" alt="" width="1300px" height="598">

        <!-- 1.点击模块出现新的div，z-index = 1 -->
        <div id="clickModule" v-show="stateClickModule == true">
            <el-button :type="buttonType1" id="buttonModule" @click="clickButtonModule" >模块</el-button>
            <el-button :type="buttonType2" id="buttonStyle" @click="clickButtonStyle" >样式</el-button>
            <el-button :type="buttonType3" id="buttonSet" @click="clickButtonSet" >设置</el-button>
            <el-button :type="buttonType4" id="buttonImprove" @click="clickButtonImprove" >百度优化</el-button>
            <i class="icon el-icon-circle-close" id="closeModule" @click="closeModule"></i>
            <!-- 2.新增栏目的模块 -->
            <br>
            <br>
            <!-- 第一组：模块组 -->
            <el-button-group v-show="stateActiveNamesGroup == true">
  <el-button type="success" icon="el-icon-edit" @click="addActiveNames">新增模块</el-button>
  <el-button type="success" icon="el-icon-share" @click="addMaterial">新增素材</el-button>
  <el-button type="success" icon="el-icon-s-flag" @click="addOption">栏目模块</el-button>
            </el-button-group>
  <!-- 第二组：样式组 -->
            <el-button-group v-show="stateStyleGroup == true">
  <el-button type="success" icon="el-icon-edit" @click="Topic">主题</el-button>
  <el-button type="success" icon="el-icon-share" @click="Primary">基础</el-button>
  <el-button type="success" icon="el-icon-s-flag" @click="Top">顶部</el-button>
            </el-button-group>
            <br>
            <br>
            <el-radio-group v-model="radio1" v-show="stateStyleGroupTopic == true">
      <el-radio-button label="主题1"></el-radio-button>
      <el-radio-button label="主题2"></el-radio-button>
      <el-radio-button label="主题3"></el-radio-button>
      <el-radio-button label="主题4"></el-radio-button>
    </el-radio-group>
            <!-- 第三组：设置组 -->
            <el-button-group v-show="stateSetGroup == true">
  <el-button type="success" icon="el-icon-edit" @click="setPrimary">基础设置</el-button>
  <el-button type="success" icon="el-icon-share" @click="setPage">页面设置</el-button>
  <el-button type="success" icon="el-icon-s-flag" @click="setImprove">高级设置</el-button>
            </el-button-group>
            <div v-show="stateSetGroupCheckTopic == true">
                浏览器标题:
                <input type="text" name="" id="checkTopic"  placeholder="网站">
            </div>
            <!-- 第四组：百度优化组 -->
            <el-button-group v-show="stateImproveGroup == true">
  <el-button type="success" icon="el-icon-edit" @click="baiduImprove">百度优化</el-button>
  <el-button type="success" icon="el-icon-share" @click="keyImprove">关键词优化</el-button>
            </el-button-group>
            <br>
            <br>

            <!-- //鼠标移动文字提示 -->
            <el-tooltip class="item" effect="dark" content="建议升级网站推广版" placement="top-start" v-show="stateImproveGroupArea == true">
      <el-button>推广版</el-button>
    </el-tooltip>

  <el-collapse v-model="activeNames" @change="handleChange" id="activeNames" accordion v-show="stateActiveNames == true">
  <el-collapse-item title="常用" name="1">
  <el-button type="info" icon="el-icon-document" @click="clickText">文本</el-button>
  <el-button type="info" icon="el-icon-picture" @click="clickPigNew">图片</el-button>
  <el-button type="info" icon="el-icon-film">按钮</el-button>
  </el-collapse-item>

    <el-collapse-item title="基础" name="2">
  <el-button type="info" icon="el-icon-document">图文展示</el-button>
  <el-button type="info" icon="el-icon-picture">列表多图</el-button>
  <el-button type="info" icon="el-icon-film">文章按钮</el-button>
  </el-collapse-item>

      <el-collapse-item title="排版" name="3">
  <el-button type="info" icon="el-icon-document">自有容器</el-button>
  <el-button type="info" icon="el-icon-picture">悬停容器</el-button>
  <el-button type="info" icon="el-icon-film">横向标签</el-button>
  </el-collapse-item>

       
  </el-collapse>

<!-- //2.新增素材模块 -->
  <div id="addMaterialMoudule" v-show="stateAddMaterialMoudule == true">
<el-input
    placeholder="请输入内容"
    prefix-icon="el-icon-search"
    v-model="input2">
  </el-input>
  </div>

  <!-- //3.栏目模块 -->
  <div id="addOptionMoudule" v-show="stateAddOptionMoudule == true">
选择栏目：<el-select v-model="value">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
  </div>

  

        </div>

                <!-- 2.点击样式出现新的div，z-index = 1 -->
        <!-- <div id="clickStyle" v-show="stateClickStyle == true">
            <i class="icon el-icon-circle-close" id="closeStyle" @click="closeStyle"></i>
        </div> -->

        <!-- 3.点击设置出现新的div，z-index = 1 -->
        <!-- <div id="clickSet" v-show="stateClickSet == true">
            <i class="icon el-icon-circle-close" id="closeSet" @click="closeSet"></i>
        </div> -->

        <!-- 4.点击百度优化出现新的div，z-index = 1 -->
        <!-- <div id="clickImprove" v-show="stateClickImprove == true">
            <i class="icon el-icon-circle-close" id="closeImprove" @click="closeImprove"></i>
        </div> -->

<!-- 点击文本按钮可以在界面新增内容 -->
        <div v-show="stateTextNew == true" id="textNew" ref="textNew" @click="checkNew" @input="changeDivTextNew($event)">{{this.textNew}}</div>
        <div v-show="stateTextNew1 == true" id="textNew1" ref="textNew1" @click="checkNew1" @input="changeDivTextNew1($event)">{{this.textNew1}}</div>
        <!-- <el-button type="primary"   >添加图片</el-button> -->
        <!-- <el-upload
     class="upload-demo"
     accept="image/jpeg,image/jpg,image/png"
     name="img"
     ref="img"
     action="../assets"
     :file-list="fileList"
     :on-error="handleError"
     :on-success="handleSucess"
     list-type="picture">
     <el-button size="small" type="primary">点击上传</el-button>
     <div slot="tip" class="el-upload__tip">只能上传jpg/png文件，且不超过500kb</div>
</el-upload> -->
<br>
<div id="editor">
    <ckeditor ref="editor" :config="config" v-model="editorData"
              @namespaceloaded="onNamespaceLoaded" @ready="onEditorReady"></ckeditor>
  </div>
<div v-show="statePigNew == true">
        <el-upload
            class="avatar-uploader"
            action="1"
            :show-file-list="false"
            :on-change="onchange"
            :before-upload="beforeAvatarUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
        </el-upload>
        <!-- <p>图片显示在外面↓</p> -->
        <!-- <img v-if="imageUrl" :src="imageUrl" style="margin: 0 auto;display: block"> -->
        <el-button style="font-size: 16px;margin-top: 50px;margin-left:-200px" @click="upload">上传</el-button>

        
    </div>
<img :src="pigAddressNew" id="pigAddressNew1">
    </div>
</template>

<script>
import axios from 'axios';
import CKEditor from 'ckeditor4-vue';
export default {
    name: 'BuildWeb',

    data() {
        return {
            editorData: '',
            // pigAddressNew:require("../assets/图片.jpg"),
            // pigAddressNew1:require(`${pigAddressNew}`),
            pigAddressNew:"",
            pigAddress:"",
flage: 0,
                imageUrl: '',
                picture: '',


            buttonType1:"",
            buttonType2:"",
            buttonType3:"",
            buttonType4:"",
            radio1: '主题1',
options: [{
          value: '选项1',
          label: '首页'
        }, {
          value: '选项2',
          label: '留言板'
        }, {
          value: '选项3',
          label: '关于我们'
        }, {
          value: '选项4',
          label: '联系我们'
        }],
        value: '',
    


            title:"编辑网站标题",
            stateClickModule:false,
            // stateClickStyle:false,
            // stateClickSet:false,
            // stateClickImprove:false,
            stateModule:true,
            stateStyle:true,
            stateSet:true,
            stateImprove:true,

            stateActiveNames:false,
            stateAddMaterialMoudule:false,
            stateAddOptionMoudule:false,

            stateActiveNamesGroup:false,
            stateActiveNamesGroup:false,
            stateStyleGroup:false,
            stateSetGroup:false,
             stateImproveGroup:false,
             stateStyleGroupTopic:false,
             stateSetGroupCheckTopic:false,
             stateImproveGroupArea:false,
             stateTextNew:false,
             statePigNew:false,
             stateTextNew1:false,


textNew:"双击编辑内容",
textNew1:"编辑内容1"
        };
    },
props: {
      config: {
        type: Object,
        default: () => {}
      },
      ready: {
        type: Function,
        default: () => {}
      }
    },
    mounted() {
        this.queryTitle();
        this.value = this.options[0].label;
        // this.queryTextNew();
    },

    methods: {

onNamespaceLoaded (CKEDITOR) {
        console.log(CKEDITOR)
      },
      onEditorReady (editor) {
        this.ready(editor)
      },

        onchange(file, fileList) {
                var _this = this
                var event = event || window.event
                var reader = new FileReader()
                file = event.target.files[0]
                // 转base64
                reader.onload = function (e) {
                    if (_this.flag === 1) {
                        _this.imageUrl = e.target.result // 将图片路径赋值给src
                        const image = new Image()
                        image.onload = function () {
                            const width = image.width
                            const height = image.height
                            console.log('参数 宽高：' + width + 'x' + height)
                        }
                        image.src = e.target.result
                    }
                }
                this.picture = file
                reader.readAsDataURL(file)
            },
            beforeAvatarUpload(file) {
                this.flag = 0
                const isJPG = file.type === 'image/jpeg'
                const isPNG = file.type === 'image/png'
                const isLt20M = file.size / 1024 / 1024 < 20
                this.size = (file.size / 1024 / 1024).toFixed(2) + 'M'
                if (isJPG) {
                    this.flag = 1
                    this.type = 'jpg'
                } else if (isPNG) {
                    this.flag = 1
                    this.type = 'png'
                } else {
                    this.$message.error('上传图片只能是 JPG或PNG 格式!')
                    this.flag = 0
                }
                if (!isLt20M) {
                    this.$message.error('上传图片大小不能超过 20MB!')
                    this.flag = 0
                }
                return false;
            },
            upload() {

                var fd = new FormData();
                fd.append('file', this.picture);
                // fd.append('name', '测试图片')
                // console.log(fd);
                // 请求方法...
                axios
                .post("http://127.0.0.1:9999/file/upload",fd)
                .then((response)=>{
                    
         if(response.data.match("图片")){
             
             this.$message("上传成功");
           //重新请求查询所有
           
           this.pigAddress = response.data;
          
         
         }})},
        

        
        //1.新增素材
        addMaterial(){
            this.stateAddOptionMoudule = false;
this.stateActiveNames = false;
this.stateAddMaterialMoudule = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;
   this.stateImproveGroupArea = false;
        },
        addOption(){
                        this.stateAddOptionMoudule = true;
this.stateActiveNames = false;
this.stateAddMaterialMoudule = false;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;
   this.stateImproveGroupArea = false;
        },
        addActiveNames(){
                        this.stateAddOptionMoudule = false;
this.stateActiveNames = true;
this.stateAddMaterialMoudule = false;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
        },
        handleChange(val) {
        console.log(val);
      },
        check(){

        
        this.$refs.text.contentEditable = true;
        
        },
                checkNew(){

        
        this.$refs.textNew.contentEditable = true;
        
        },
        
                checkNew1(){

        
        this.$refs.textNew1.contentEditable = true;
        
        },
        clickText(){
            this.stateTextNew = true;
            this.stateTextNew1 = true;
        },
        changeDivText($event){
        this.title = event.target.innerHTML;
        }
        ,
                changeDivTextNew($event){
        this.textNew = event.target.innerHTML;
        }
        ,
        changeDivTextNew1($event){
        this.textNew1 = event.target.innerHTML;
        }
        ,

        //上传图片
        clickPigNew(){
            this.statePigNew = true;
        },
        
        save(){
            console.log(this.pigAddress);
axios
.post("http://127.0.0.1:9999/webTitle/saveTitle?title="+this.title+"&textNew="+this.textNew+"&pigAddress="+this.pigAddress+"&textNew1="+this.textNew1)
.then((response)=>{
    if(response.data.code == 200){
        
    }else{
        this.$message.error("保存失败");
    }

});
        
//发第二个axios
axios
.post("http://127.0.0.1:9999/webTitle/saveTitle1?textNew1="+this.textNew1)
.then((response)=>{
    if(response.data.code == 200){
        this.$message("保存成功");
    }else{
        this.$message.error("保存失败");
    }
    });

        },
        //第二个方法，从数据库读标题，加载到网页中
        queryTitle(){
            // console.log(this.pigAddressNew);
            console.log(123);
            axios
            .get("http://127.0.0.1:9999/webTitle/queryTitle")
            .then((response)=>{
                // console.log(response.data.data);
                this.title = response.data.data[0].content;
                this.textNew = response.data.data[0].textNew;
                if(response.data.data[0].textNew1 != null){

               
                     this.stateTextNew1 = true;
this.textNew1 = response.data.data[0].textNew1;
                }
                
                this.stateTextNew = true;
               
                // console.log(response.data.data[0].pigAddress);
                // var icon = "'"+response.data.data[0].pigAddress+"'";
                // console.log(icon);
                this.pigAddressNew = require('../assets/'+response.data.data[0].pigAddress+'.jpg');
                // this.pigAddressNew = ""+response.data.data[0].pigAddress;
                console.log(this.pigAddressNew)
               
                
            })
        },
//         queryTextNew(){
// axios
//             .get("http://127.0.0.1:9999/webTitle/queryTextNew")
//             .then((response)=>{
//                 console.log(response.data.data);
//                 this.textNew = response.data.data[0].content;
//                 this.stateTextNew = true;
//             })
//         },
        cacle(){
            this.title = "编辑网站标题";
        },


        clickModule(){
this.buttonType1 = "primary";
this.buttonType2 = "";
this.buttonType3 = "";
this.buttonType4 = "";

            this.stateActiveNamesGroup = true;
            this.stateActiveNames = true;
            
this.stateClickModule = true;
this.stateModule = false;
this.stateStyle = false;
this.stateSet = false;
this.stateImprove = false;

//回点，置为false的一组
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
// this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = false;
this.stateStyleGroup = false;
// this.stateActiveNamesGroup = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
        },
        //2.关闭按钮
        closeModule(){
            this.stateClickModule = false;
this.stateModule = true;
this.stateStyle = true;
this.stateSet = true;
this.stateImprove = true;
        },
        //3.点击样式出现div的方法
        clickStyle(){
            this.buttonType1 = "";
this.buttonType2 = "primary";
this.buttonType3 = "";
this.buttonType4 = "";
            
this.stateActiveNamesGroup = true;
            this.stateActiveNames = false;
            
this.stateClickModule = true;
this.stateModule = false;
this.stateStyle = false;
this.stateSet = false;
this.stateImprove = false;

//回点，置为false的一组
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
// this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = false;
this.stateStyleGroup = true;
this.stateActiveNamesGroup = false;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
        },
//         //4.关闭按钮
//         closeStyle(){
//             this.stateClickStyle = false;
// this.stateModule = true;
// this.stateStyle = true;
// this.stateSet = true;
// this.stateImprove = true;
//         },
        //5.点击设置出现div的方法
        clickSet(){
                        this.buttonType1 = "";
this.buttonType2 = "";
this.buttonType3 = "primary";
this.buttonType4 = "";
            
            
this.stateActiveNamesGroup = true;
            this.stateActiveNames = false;
            
this.stateClickModule = true;
this.stateModule = false;
this.stateStyle = false;
this.stateSet = false;
this.stateImprove = false;

//回点，置为false的一组
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
// this.stateActiveNames = false;
this.stateSetGroup = true;
this.stateImproveGroup = false;
this.stateStyleGroup = false;
this.stateActiveNamesGroup = false;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
        },
//         //6.关闭按钮
//         closeSet(){
//             this.stateClickSet = false;
// this.stateModule = true;
// this.stateStyle = true;
// this.stateSet = true;
// this.stateImprove = true;
//         },
        //7.点击百度优化出现div的方法
        clickImprove(){
                                    this.buttonType1 = "";
this.buttonType2 = "";
this.buttonType3 = "";
this.buttonType4 = "primary";
            
this.stateActiveNames = false;
            
this.stateClickModule = true;
this.stateModule = false;
this.stateStyle = false;
this.stateSet = false;
this.stateImprove = false;

//回点，置为false的一组
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
// this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = true;
this.stateStyleGroup = false;
this.stateActiveNamesGroup = false;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;


        },
//         //8.关闭按钮
//         closeImprove(){
//             this.stateClickImprove = false;
// this.stateModule = true;
// this.stateStyle = true;
// this.stateSet = true;
// this.stateImprove = true;
//         }

//1.点击模块按钮
clickButtonModule(){
this.buttonType1 = "primary";
this.buttonType2 = "";
this.buttonType3 = "";
this.buttonType4 = "";

this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = false;
this.stateStyleGroup = false;
this.stateActiveNamesGroup = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
},
//2.点击样式按钮
clickButtonStyle(){
this.buttonType1 = "";
this.buttonType2 = "primary";
this.buttonType3 = "";
this.buttonType4 = "";

this.stateActiveNamesGroup = false;
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = false;
this.stateStyleGroup = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
},
//3.点击设置按钮
clickButtonSet(){
this.buttonType1 = "";
this.buttonType2 = "";
this.buttonType3 = "primary";
this.buttonType4 = "";
    
    this.stateStyleGroup = false;
this.stateActiveNamesGroup = false;
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
this.stateActiveNames = false;
this.stateImproveGroup = false;
this.stateSetGroup = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;

   this.stateImproveGroupArea = false;
},
//4.点击百度优化按钮
clickButtonImprove(){
this.buttonType1 = "";
this.buttonType2 = "";
this.buttonType3 = "";
this.buttonType4 = "primary";

    this.stateStyleGroup = false;
this.stateActiveNamesGroup = false;
this.stateAddMaterialMoudule = false;
this.stateAddOptionMoudule = false;
this.stateActiveNames = false;
this.stateSetGroup = false;
this.stateImproveGroup = true;
this.stateStyleGroupTopic = false;
this.stateSetGroupCheckTopic = false;
   this.stateImproveGroupArea = false;

},

//点击样式组的主题按钮
Topic(){
    this.stateStyleGroupTopic = true;
        this.stateSetGroupCheckTopic = false;
           this.stateImproveGroupArea = false;
},

//点击设置组的主题设置
setPrimary(){
    this.stateSetGroupCheckTopic = true;
     this.stateImproveGroupArea = false;
},
//点击百度优化组的百度优化
baiduImprove(){
    this.stateImproveGroupArea = true;
}
    },//methos结束
};//export结束
</script>

<style lang="scss" scoped>
.avatar-uploader .el-upload {
        border: 1px solid #d9d9d9;
        border-radius: 6px;
        cursor: pointer;
        position: relative;
        overflow: hidden;

    }
    .avatar-uploader .el-upload:hover {
        border-color: #409EFF;
    }
    .avatar-uploader-icon {
        border: 1px solid;
        font-size: 28px;
        color: #8c939d;
        width: 178px;
        height: 178px;
        line-height: 178px;
        text-align: center;
        margin-left: -200px;
    }
    .avatar {
        width: 178px;
        height: 178px;
        display: block;
    }


#webManage{
    margin-left: -1000px;
}

#title{
    margin-left:100px;
    font-size: 30px;
    float: left;
}
#buy{
    margin-left:300px;
    font-size: 15px;
    float: left;
}
#save{
    margin-left:300px;
    font-size: 15px;
    float: left;
}
#look{
    margin-left:30px;
    font-size: 15px;
    float: left;
}
#cacle{
    margin-left:30px;
    font-size: 15px;
    float: left;
}


#index{
    margin-left:500px;
    font-size: 15px;
    float: left;
    
    
}#say{
   
    margin-left:50px;
    font-size: 15px;
    float: left;
}#aboutOur{
    margin-left:50px;
    font-size: 15px;
    float: left;
}#withOur{
    margin-left:50px;
    font-size: 15px;
    float: left;
}











#module{
    margin-top: 50px;
    margin-left:-700px;
    font-size: 25px;
  
}
#style{
    position: relative;
    left: -107px;
    top:70px;
    font-size: 25px;
  
}
#set{
    position: relative;
    left: -214px;
    top:140px;
    font-size: 25px;
  
}
#improve{
    position: relative;
    left: -321px;
    top:210px;
    font-size: 25px;
  
}


#pig{
    position: absolute;
    left:0px;
    top:180px;
    Z-index:-1;
}
//1.模块样式
#clickModule{
    background-color:#ffff;
    border: 1px solid;
    position: absolute;
    left:50px;
    top:153px;
    width: 400px;
    height: 400px;
    Z-index:1;
}

#closeModule{
    position: relative;
    left:10px;
    top:5px;
}

// //2.样式参数设定样式
// #clickStyle{
//     border: 1px solid;
//     position: absolute;
//     left:250px;
//     top:190px;
//     width: 250px;
//     height: 300px;
//     Z-index:1;
// }

// #closeStyle{
//     position: relative;
//     left:100px;
//     top:5px;
// }

// //3.设置样式
// #clickSet{
//     border: 1px solid;
//     position: absolute;
//     left:250px;
//     top:190px;
//     width: 250px;
//     height: 300px;
//     Z-index:1;
// }

// #closeSet{
//     position: relative;
//     left:100px;
//     top:5px;
// }

// //4.百度优化样式
// #clickImprove{
//     border: 1px solid;
//     position: absolute;
//     left:250px;
//     top:190px;
//     width: 250px;
//     height: 300px;
//     Z-index:1;
// }

// #closeImprove{
//     position: relative;
//     left:100px;
//     top:5px;
// }

// #buttonModule{
//     position: relative;
//     left: 0px;
//     top: 5px;
// }

// #buttonStyle{
//     position: relative;
//     left: 0px;
//     top: 5px;
// }

// #buttonSet{
//     position: relative;
//     left: 0px;
//     top: 5px;
// }

// #buttonImprove{
//     position: relative;
//     left: 0px;
//     top: 5px;
// }


#activeNames{
    position: relative;
    
    left:0px;
    top:30px;
   
}
#textNew{
    position: absolute;
    left: 1000px;
    top: 300px;
}
#textNew1{
    position: absolute;
    left: 1000px;
    top: 250px;
}
#pigAddressNew1{
    position: absolute;
    left: 800px;
    top: 190px;
}
#editor{
        position: absolute;
    left: 700px;
    top: 330px;
    width: 580px;
    height: 0px;
}
</style>