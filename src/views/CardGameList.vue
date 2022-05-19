<template>
    <div>
      <input  
  id="file1"
  name="file"
 ref="getChangeFile"
  type="file"
  @change="inputCustomProduct()">
      <el-button type="primary" @click="exportToExcel"> 导出 </el-button>
        <el-table
    :data="currentPageData"
    border
    style="width: 100%"
    id="exportTable"
    v-load="listLoading">
    <el-table-column
      prop="id"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="title"
      label="主题"
      width="180">
    </el-table-column>
    <el-table-column label="活动图片">
              <!-- <el-table-item v-for="(item,index) in tableData" :key="index" >
        
　　　　<img :src="item.pic" width="40" height="40" class="head_pic"/>
</el-table-item> -->
<template slot-scope="scope">
　　　　<img :src="scope.row.pic" width="40" height="40" class="head_pic"/>
      </template>
</el-table-column>
    <el-table-column
      prop="content"
      label="活动内容">
    </el-table-column>

    <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-edit"
            circle
            size="mini"
            @click="handleEdit(scope.$index, scope.row)"
          ></el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            circle
            size="mini"
            @click="handleDelete(scope.$index, scope.row)"
          ></el-button>
        </template>
      </el-table-column>
  </el-table>

  <br>
  <input type="button" value="首页" @click="firstPage">
<input type="button" value="上一页" @click="prevPage">
<input type="button" value="下一页" @click="nextPage">
<input type="button" value="尾页" @click="lastPage">
    </div>
</template>

<script>
import axios from 'axios';
import FileSaver from 'file-saver'
import XLSX from 'xlsx'

export default {
    name: 'CardGameList',

    data() {
        return {
            tableData: [],
            listLoading: true,
      totalPage: 1, // 统共页数，默认为1
            currentPage: 1, //当前页数 ，默认为1
            pageSize: 2, // 每页显示数量
      currentPageData: [], //当前页显示内容
      headPage: 1
            
        };
    },

    mounted() {
      this.queryCardGameList();
        
    },

    methods: {

      queryCardGameList(){
        axios
        .get("http://127.0.0.1:9999/cardGame/queryCardGameList")
        .then((response)=>{
          this.tableData = response.data.data;
          this.listLoading = false;

          this.totalPage=Math.ceil(this.tableData.length / this.pageSize);
        this.totalPage = this.totalPage == 0 ? 1 : this.totalPage;
        this.getCurrentPageData();
        })
      },
      //设置当前的数据界面
      getCurrentPageData() {
                        let begin = (this.currentPage - 1) * this.pageSize;
                        let end = this.currentPage * this.pageSize;
                        this.currentPageData = this.tableData.slice(
                            begin,
                            end
                        );
                    },

                    //2.设置首页尾页的功能
                    //上一页
prevPage() {
                       
          if (this.currentPage == 1) {
                 return false;
             } else {
                 this.currentPage--;
                 this.getCurrentPageData();
                }
                    },
                    // 下一页
                    nextPage() {
 
                        if (this.currentPage == this.totalPage) {
                            return false;
                        } else {
                            this.currentPage++;
                            this.getCurrentPageData();
                        }
              },
              //尾页
              lastPage() {
 
               if (this.currentPage == this.totalPage) {
                     return false;
                        } else {
                     this.currentPage=this.totalPage;
                      this.getCurrentPageData();
                  }
                  
              } ,
           //首页
              firstPage(){
             this.currentPage=  this.headPage;
             this.getCurrentPageData();
},

      //1.删除活动的方法
      handleDelete(index, row) {
      console.log(index);
      console.log(row.id);
      //弹出框提示你确认要删除吗？ 发ajax传递id完成删除，if code==200,重新查询所有this.queryCardGameList(); 
      this.$confirm("此操作将永久删除该文件，是否继续？","提示",{
        confirmButtonText:"确定",
        cancelButtonText:"取消",
        type:"warning",
      })
        .then(()=>{
          //发送ajax请求完成删除
          axios
            .post(
              "http://127.0.0.1:9999/cardGame/deleteCardGameList/" + row.id
            )
            .then((response)=>{
              if(response.data.code == 200){
                //重新请求查询所有
                this.queryCardGameList();
                this.$message({
                  type:"success",
                  message:"删除成功！",
                })
              }
            })
        })
        .catch(()=>{
          this.$message({
            type:"info",
            message:"已取消删除",
          })
        })
    },
    // 表格数据写入excel，并导出为Excel文件
exportToExcel(){
  const XLSX = require('xlsx')
  console.log('XLSX',XLSX,FileSaver)
  // 使用 this.$nextTick 是在dom元素都渲染完成之后再执行
  this.$nextTick(function () {
	// 设置导出的内容是否只做解析，不进行格式转换     false：要解析， true:不解析
	const xlsxParam = { raw: true } 
	const wb = XLSX.utils.table_to_book(document.querySelector('#exportTable'), xlsxParam)
	// 导出excel文件名
	let fileName = '活动列表' + new Date().getTime() + '.xlsx'
	
	const wbout = XLSX.write(wb, { bookType: 'xlsx', bookSST: true, type: 'array' })
	try {
	  // 下载保存文件
	  FileSaver.saveAs(new Blob([wbout], { type: 'application/octet-stream' }), fileName)
	} catch (e) {
	  if (typeof console !== 'undefined') {
		console.log(e, wbout)
	  }
	}
	return wbout
  })
},
//用excel表格导进文件，添加列表
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
   .post("http://127.0.0.1:9999/cardGame/upload",formData)
   .then((response)=>{
     console.log(response);
     console.log("1");
     console.log(response.data);
     if(response.data == "success"){
       this.$message("导入成功！");
       this.queryCardGameList();
     }else{
       this.$message.error("导入失败！");
     }
   })
        },

        
    },//methos结束
};//export结束
</script>

<style lang="scss" scoped>

</style>