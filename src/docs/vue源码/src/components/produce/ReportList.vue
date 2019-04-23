<template>
	<div>
		<h1 style="text-align: center">报岗信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width:160px' placeholder='船队名称' v-model='search_shipname'></el-input>
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="reportid" label="ID" width="80"></el-table-column>
				<el-table-column prop="shipname" label="船队名称" width="100"></el-table-column>
				<el-table-column prop="capacity" label="装载量" width="80"></el-table-column>
				<el-table-column prop="planjobtime" label="预计到港时间" width="190"></el-table-column>
				<el-table-column prop="startjobtime" label="实际到港时间" width="190"></el-table-column>
				<el-table-column prop="completetime" label="完成时间" width="190"></el-table-column>
				<el-table-column prop="flowname" label="流程" width="100"></el-table-column>
				<el-table-column prop="reportuser" label="报岗人" width="80"></el-table-column>
				<el-table-column prop="compname" label="所属企业" width="120"></el-table-column>
				<el-table-column label="操作" width="180">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row.reportid)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.reportid)">删除</el-button>
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
				search_shipname:'',
				list:[]
			};
		},
		methods:{
			update(reportid){
				this.$router.push({name:'ReportEdit',params:{reportid:reportid}});
			},
			del(reportid){
				var url = this.baseUrl+"/produceReport/delete"
				var data = {reportid:reportid};
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
				this.$router.push("/ReportAdd");
			},
			search(){
				var url = this.baseUrl+"/produceReport/search"
				var data = {shipname:this.search_shipname};
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
