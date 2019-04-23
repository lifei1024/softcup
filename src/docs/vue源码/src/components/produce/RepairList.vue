<template>
	<div>
		<h1 style="text-align: center">维修信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-select  placeholder="请选择设备名称" style='width:160px' v-model='search_devid'>
										<el-option v-for="item in devs" :key="item.devid" :label="item.devname" :value="item.devid">
										</el-option>
									  </el-select>
			
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="repairid" label="ID" width="80"></el-table-column>
				<el-table-column prop="devname" label="设备名称" width="120"></el-table-column>
				<el-table-column prop="cause" label="维修原因" width="120"></el-table-column>
				<el-table-column prop="cost" label="维修费用" width="120"></el-table-column>
				<el-table-column prop="repairdate" label="维修日期" width="120"></el-table-column>
				<el-table-column label="操作" width="180">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row.repairid)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.repairid)">删除</el-button>
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
				search_devid:'',
				devs:[],
				list:[]
			};
		},
		methods:{
			update(repairid){
				this.$router.push({name:'RepairEdit',params:{repairid:repairid}});
			},
			del(repairid){
				var url = this.baseUrl+"/produceRepair/delete"
				var data = {repairid:repairid};
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
				this.$router.push("/RepairAdd");
			},
			search(){
				var url = this.baseUrl+"/produceRepair/search"
				var data = {devid:this.search_devid};
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
			var url = this.baseUrl+"/baseDevice/list";
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.devs = res.data;
			})
		}
		
	}
</script>

<style>

</style>
