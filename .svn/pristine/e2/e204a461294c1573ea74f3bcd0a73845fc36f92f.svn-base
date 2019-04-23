<template>
	<div>
		<h1 style="text-align: center">用户信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width:160px' placeholder='用户姓名' v-model='search_cname'></el-input>
			<el-input style='width:160px' placeholder='用户名' v-model='search_username'></el-input>
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="userid" label="ID" width="80"></el-table-column>
				<el-table-column prop="cname" label="姓名" width="120"></el-table-column>
				<el-table-column prop="username" label="用户名" width="120"></el-table-column>
				<el-table-column prop="password" label="密码" width="120"></el-table-column>
				<el-table-column prop="telno" label="电话" width="120"></el-table-column>
				<el-table-column prop="email" label="邮箱" width="120"></el-table-column>
				<el-table-column prop="sex" label="性别" width="120"></el-table-column>
				<el-table-column prop="baseCompany.compname" label="所属企业" width="120"></el-table-column>
				<el-table-column label="操作" width="180">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row.userid)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.userid)">删除</el-button>
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
				search_cname:'',
				search_username:'',
				list:[]
			};
		},
		methods:{
			update(userid){
				this.$router.push({name:'UserEdit',params:{userid:userid}});
			},
			del(userid){
				var url = this.baseUrl+"/baseUser/delete"
				var data = {userid:userid};
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
				this.$router.push("/UserAdd");
			},
			search(){
				var url = this.baseUrl+"/baseUser/search"
				var data = {cname:this.search_cname,username:this.search_username};
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
