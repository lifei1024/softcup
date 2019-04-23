<template>
	<div>
		<h1 style="text-align: center">能耗信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-select  placeholder="请选择设备名称" style='width:160px' v-model='search_devid'>
										<el-option v-for="item in devs" :key="item.devid" :label="item.devname" :value="item.devid">
										</el-option>
									  </el-select>
			
			<el-button @click='search'>查询</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="consumeid" label="ID" width="80"></el-table-column>
				<el-table-column prop="devname" label="设备名称" width="120"></el-table-column>
				<el-table-column prop="electric" label="电耗(kw.h)" width="190"></el-table-column>
				<el-table-column prop="water" label="水耗(吨)" width="190"></el-table-column>
				<el-table-column prop="oil" label="油耗(L)" width="190"></el-table-column>
				<el-table-column prop="reportid" label="报岗id" width="120"></el-table-column>
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
			search(){
				var url = this.baseUrl+"/energyConsume/search"
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
