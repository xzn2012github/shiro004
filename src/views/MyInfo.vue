<template>
    <div>
//上传图片
                    <el-upload
                        class="upload-demo"
                        ref="client_upload"
                        accept=""
                        action="http://127.0.0.1:9999/file/upload"
                        :on-preview="handlePreview"
                        :on-remove="handleRemove"
                        :on-error="handleError"
                        :on-progress="handleProgress"
                        :on-success="handleSuccessForUp"
                        :file-list="fileList"
                      >
                        <el-button size="small" type="primary"
                          >上传<i class="el-icon-upload el-icon--right"></i
                        ></el-button>
                     </el-upload>


        <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="userid"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="realname"
      label="真实姓名"
      width="180">
    </el-table-column>
    <!-- <el-table-column
      prop="pic"
      label="个人头像"
      width="180">
      <img :src="this.tableData[2]">

    </el-table-column> -->
    <el-table-column label="个人头像">
　　　　<img :src="this.tableData[0].pic" width="40" height="40" class="head_pic"/>
</el-table-column>
    <el-table-column
      prop="idCard"
      label="身份证">
    </el-table-column>
    <el-table-column
      prop="phone"
      label="电话号码"
      width="180">
    </el-table-column>
    <el-table-column
      prop="level"
      label="会员等级"
      width="180">
    </el-table-column>
  </el-table>

  <br>
  <el-button type="primary" @click="dialogFormVisible = true">添加用户信息</el-button>&nbsp;&nbsp;&nbsp;&nbsp;
  <el-button type="primary" @click="updateMyInfoNew()">修改用户信息</el-button>

  <!-- 添加模态框-->
    <el-dialog title="添加" :visible.sync="dialogFormVisible">
      <el-form :model="saveForm" ref="saveForm" id="form">
        <el-form-item
        label="账号"
        :label-width="formLabelWidth"
        prop="uname">
          <el-input v-model="saveForm.uname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item
        label="密码"
        :label-width="formLabelWidth"
        prop="upass"
        show-password>
          <el-input v-model="saveForm.upass" autocomplete="off" show-password></el-input>
        </el-form-item>
        <el-form-item
        label="真实姓名"
        :label-width="formLabelWidth"
        prop="realname">
          <el-input v-model="saveForm.realname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item
        label="个人头像"
        :label-width="formLabelWidth"
        prop="pic">
          <el-input
            v-model="saveForm.pic"
            autocomplete="off"
            ></el-input>
<!-- <el-button type="primary" @click="up()">上传图片</el-button> -->
<input  
  id="file1"
  name="file"
 ref="getChangeFile"
  type="file"
  @change="inputCustomProduct()">
            <!-- <el-button type="primary" @click="upload">上传图片</el-button> -->
        </el-form-item>
        <el-form-item
        label="身份证"
        :label-width="formLabelWidth"
        prop="idCard">
          <el-input
            v-model="saveForm.idCard"
            autocomplete="off"
            ></el-input>
        </el-form-item>
        <el-form-item
        label="电话号码"
        :label-width="formLabelWidth"
        prop="phone">
          <el-input
            v-model="saveForm.phone"
            autocomplete="off"
            ></el-input>
        </el-form-item>
        <el-form-item
        label="会员等级"
        :label-width="formLabelWidth"
        prop="level">
          <el-input
            v-model="saveForm.level"
            autocomplete="off"
            ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="saveMyInfo('saveForm')">确定</el-button>
        <el-button @click="dialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>



    
    <!-- 2.修改模态框-->
    <el-dialog title="修改" :visible.sync="dialogUpdateFormVisible">
      <el-form :model="updateForm" ref="updateForm" id="form">
        <el-form-item
        label="序号"
        :label-width="formLabelWidth"
        prop="userid"
        style="display:none">
          <el-input v-model="updateForm.userid" autocomplete="off" ></el-input>
        </el-form-item>
        <el-form-item
        label="账号"
        :label-width="formLabelWidth"
        prop="uname">
          <el-input v-model="updateForm.uname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item
        label="密码"
        :label-width="formLabelWidth"
        prop="upass"
        show-password>
          <el-input v-model="updateForm.upass" autocomplete="off" show-password></el-input>
        </el-form-item>
        <el-form-item
        label="真实姓名"
        :label-width="formLabelWidth"
        prop="realname">
          <el-input v-model="updateForm.realname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item
        label="个人头像"
        :label-width="formLabelWidth"
        prop="pic">
          <el-input
            v-model="updateForm.pic"
            autocomplete="off"
            ></el-input>
<!-- <el-button type="primary" @click="up()">上传图片</el-button> -->
<input  
  id="file1"
  name="file"
 ref="getChangeFile"
  type="file"
  @change="inputCustomProduct()">
            <!-- <el-button type="primary" @click="upload">上传图片</el-button> -->
        </el-form-item>
        <el-form-item
        label="身份证"
        :label-width="formLabelWidth"
        prop="idCard">
          <el-input
            v-model="updateForm.idCard"
            autocomplete="off"
            ></el-input>
        </el-form-item>
        <el-form-item
        label="电话号码"
        :label-width="formLabelWidth"
        prop="phone">
          <el-input
            v-model="updateForm.phone"
            autocomplete="off"
            ></el-input>
        </el-form-item>
        <el-form-item
        label="会员等级"
        :label-width="formLabelWidth"
        prop="level">
          <el-input
            v-model="updateForm.level"
            autocomplete="off"
            ></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="updateMyInfo('updateForm')">确定</el-button>
        <el-button @click="dialogFormVisible = false">取消</el-button>
      </div>
    </el-dialog>

    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Myinfo',
    

    data() {
        return {
           dialogUpdateFormVisible:false, //修改模态框的显示状态
           dialogFormVisible:false, //添加模态框的显示状态
           formLabelWidth:"120px",
            tableData: [],
            saveForm:{
        //添加表单
        uname:"",
        upass:"",
        realname:"",
        pic:"",
        idCard:"",
        phone:"",
        level:""

        
      },
      state:false,
      updateForm:{
        //修改表单
        userid:"",
        uname:"",
        upass:"",
        realname:"",
        pic:"",
        idCard:"",
        phone:"",
        level:""

        
      },
            
        };
    },

    mounted() {
      this.queryMyInfo();
        
    },

    methods: {
//1.VUE方法上传文件
handleRemove(file, fileList) {
      console.log(file, fileList);
    },
    handleProgress(event, file, fileList){
      this.loading = Loading.service({
        lock: true,
        text: '程序正在升级，请耐心等待;或者完毕后手动刷新',
        spinner: 'el-icon-loading',
        background: 'rgba(0, 0, 0, 0.7)'
      })
    },
    handlePreview(file) {
      console.log(file);
    },
    beforeRemove(file, fileList) {
      return this.$confirm(`确定移除 ${file.name}？`);
    },
    handleSuccess(res, file, fileList) {
      console.log(res);
      if (res.flag) {
        this.$message.success(res.message);
        this.findUpgradeFileVersion();
      } else {
        this.$message.error(res.message);
      }
    },
    handleError(res, file, fileList) {
          let errorStr = res.toString();
          let errorStr2 = errorStr.replace("Error:","");
          const Error = JSON.parse(errorStr2);
          this.$message.error(Error.error_description);
          this.loading.close()
    },

 queryMyInfoNew(){
        axios
        .get("http://127.0.0.1:9999/cardGameUser/queryMyInfoNew")
        .then((response) =>{
          this.updateForm = response.data.data[0];

        });
      },
      updateMyInfoNew(){
      this.dialogUpdateFormVisible = true;
     this.queryMyInfoNew();
      },

      queryMyInfo(){
        axios
        .get("http://127.0.0.1:9999/cardGameUser/queryMyInfo1")
        .then((response) =>{
          this.tableData = response.data.data;

        });
      },
        
    
//添加个人信息的功能
    saveMyInfo(formName){
      //添加
      console.log("--发送ajax请求");
      axios
       .post("http://127.0.0.1:9999/cardGameUser/saveMyInfoSalt",this.saveForm)
       .then((response)=>{
         if(response.data.code == 200){
           //重新请求查询所有
           this.queryMyInfo();
           this.$message({
             type:"success",
             message:"添加成功!",
           })
           this.dialogFormVisible = false; //关闭模态框
           //清空表单
           this.$refs[formName].resetFields();
         }
       })
    },

    //2.修改个人信息功能
    
    
    updateMyInfo(formName){
      //修改
      


      console.log("--发送ajax请求");
      axios
       .post("http://127.0.0.1:9999/cardGameUser/updateMyInfo",this.updateForm)
       .then((response)=>{
         if(response.data.code == 200){
           //重新请求查询所有
           this.queryMyInfo();
           this.$message({
             type:"success",
             message:"修改成功!",
           })
           this.dialogUpdateFormVisible = false; //关闭模态框
           //清空表单
           this.$refs[formName].resetFields();
         }
       })
    },


//点击按钮上传图片
upload(){
  console.log("123");
  axios
  .post("http://127.0.0.1:9999/upload1/upload")
  .then((response)=>{
    this.saveForm.pic = this.response.data.data;
  })

},
// 上传文件
        up(){
          this.saveForm.pic = '123';
            event.preventDefault();
            //因为样式问题，点击button按钮触发input
            // this.state = true;
        },
        inputCustomProduct(){
          var fileObj = document.getElementById("file1").files[0]; // js 获取文件对象
          // console.log(fileObj);
          // var file = this.$refs['getChangeFile'].getAddFile;
          // console.log(file);
          var formData = new window.FormData();
          // var file = new FormData(document.getElementById("form")); // FormData 对象
          // console.log(file);
formData.append("file",fileObj);
// file.append("file", fileObj); // 文件对象
// console.log(file);
          // var file = this.$refs['upload'];
          // console.log(form);
        //     console.log(el)
            
        // this.saveForm.pic = '123';
        //     // let that = this;
        //     //声明一个FormDate对象
        //     let formData = new FormData();
        //     let file = el.target.files[0];
        //      console.log(file)
        //     //把文件信息放入对象中
        //     formData.append("multipartFile", file);
        //     // console.log(FormData.get("multipartFile"));
        //     config={
        //         headers: {
        //             "Content-Type": "multipart/form-data"
        //         }
        //     };
        //     axios.post('http://127.0.0.1:9999/upload1/upload',formData,config).then(res=>{
        //     //成功后调用的代码
        //     this.saveForm.pic = this.response.data.data;
        //     console.log(res);
        // }).catch(result=>{
        //    //失败后调用的代码
        //         console.log(result)
        //     })
  //       console.log(formData);
  //       this.saveForm.pic = '123';
         axios
   .post("http://127.0.0.1:9999/upload1/upload",formData)
   .then((response)=>{
     console.log(response);
     this.saveForm.pic =response.data;
   })
        },

}//方法methos的结束
};//export default的结束
</script>

<style lang="scss" scoped>

</style>