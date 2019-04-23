<template>
	<div>
		<h1 style="text-align: center">企业信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width:160px' placeholder='公司名称' v-model='search_compname'></el-input>
			<el-input style='width:160px' placeholder='行业' v-model='search_industry'></el-input>
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="compid" label="ID" width="80"></el-table-column>
				<el-table-column prop="compname" label="公司名称" width="120"></el-table-column>
				<el-table-column prop="contacts" label="联系人" width="120"></el-table-column>
				<el-table-column prop="comptel" label="联系电话" width="120"></el-table-column>
				<el-table-column prop="industry" label="行业" width="180"></el-table-column>
				<el-table-column prop="address" label="地址" width="180"></el-table-column>
				<el-table-column label="操作" width="230">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.compid)">删除</el-button>
				  </template>
				</el-table-column>
			</el-table>
		</center>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				search_compname:'',
				search_industry:'',
				list:[]
			};
		},
		methods:{
			update(row){
				this.$router.push({name:'CompEdit',params:{row:row}});
			},
			del(compid){
				var url = this.baseUrl+"/baseCompany/delete"
				var data = {compid:compid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					this.$message("删除成功");
					this.search();
			    })
			},
			add(){
				this.$router.push("/CompAdd");
			},
			search(){
				var url = this.baseUrl+"/baseCompany/search"
				var data = {compname:this.search_compname,industry:this.search_industry};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					this.list = res.data;
				})
			}
		},
		mounted:function(){
			this.search();
		}
		
	}
</script>

<style>

</style>
