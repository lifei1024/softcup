<template>
	<div>
		<h1 style="text-align: center">流程信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width:160px' placeholder='流程名称' v-model='search_flowname'></el-input>
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="flowid" label="ID" width="80"></el-table-column>
				<el-table-column prop="flowname" label="流程名称" width="120"></el-table-column>
				<el-table-column prop="dljname" label="斗轮机" width="120"></el-table-column>
				<el-table-column prop="zcjname" label="装船机" width="120"></el-table-column>
				<el-table-column prop="pdjname" label="皮带机" width="120"></el-table-column>
				<el-table-column prop="compname" label="所属企业" width="120"></el-table-column>
				<el-table-column label="操作" width="180">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row.flowid)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.flowid)">删除</el-button>
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
				search_flowname:'',
				list:[]
			};
		},
		methods:{
			update(flowid){
				this.$router.push({name:'FlowEdit',params:{flowid:flowid}});
			},
			del(flowid){
				var url = this.baseUrl+"/baseFlow/delete"
				var data = {flowid:flowid};
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
				this.$router.push("/FlowAdd");
			},
			search(){
				var url = this.baseUrl+"/baseFlow/search"
				var data = {flowname:this.search_flowname};
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
