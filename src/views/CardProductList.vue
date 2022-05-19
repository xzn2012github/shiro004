<template>
    <div>
        <el-table
    :data="tableData"
    border
    style="width: 100%">
    <el-table-column
      prop="id"
      label="序号"
      width="180">
    </el-table-column>
    <el-table-column
      prop="pname"
      label="奖品名称"
      width="180">
    </el-table-column>
    <el-table-column label="奖品图片">
      <template slot-scope="scope">
　　　　<img :src="scope.row.pic" width="40" height="40" class="head_pic"/>
      </template>
</el-table-column>
    <el-table-column
      prop="content"
      label="奖品内容">
    </el-table-column>
    <el-table-column
      prop="price"
      label="奖品价格">
    </el-table-column>
  </el-table>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    name: 'CardProductList',

    data() {
        return {
            tableData: []
            
        };
    },

    mounted() {
      this.queryCardProductList();
        
    },

    methods: {
      queryCardProductList(){
        axios
        .get("http://127.0.0.1:9999/cardProduct/queryCardProductList")
        .then((response)=>{
          this.tableData = response.data.data;
        })
      }
        
    },
};
</script>

<style lang="scss" scoped>

</style>