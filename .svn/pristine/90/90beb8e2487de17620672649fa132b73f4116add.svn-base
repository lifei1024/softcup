<template>
	<div>
		<h1 style="text-align: center">设备信息</h1>
		<div style="text-align: left;margin:0 0 20px 50px;">
			<el-input style='width:160px' placeholder='设备名称' v-model='search_devname'></el-input>
			<el-select  placeholder="请选择设备类别" style='width:160px;' v-model='search_typeid'>
				<el-option v-for="item in devtypes" :key="item.typeid" :label="item.typename" :value="item.typeid">
				</el-option>
			  </el-select>
			<el-button @click='search'>查询</el-button>
			<el-button @click='add'>添加</el-button>
		</div>
		<center>
			<el-table :data="list">
				<el-table-column prop="devid" label="ID" width="80"></el-table-column>
				<el-table-column prop="devname" label="设备名称" width="120"></el-table-column>
				<el-table-column prop="baseDevtype.typename" label="设备类别" width="120"></el-table-column>
				<el-table-column prop="devdate" label="投入时间" width="120"></el-table-column>
				<el-table-column prop="devuser" label="责任人" width="120"></el-table-column>
				<el-table-column prop="baseCompany.compname" label="所属企业" width="120"></el-table-column>
				<el-table-column label="操作" width="230">
				  <template slot-scope="scope">
					<el-button size="mini" @click="update(scope.row.devid)">编辑</el-button>
					<el-button size="mini" type='danger' @click="del(scope.row.devid)">删除</el-button>
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
				search_devname:'',
				search_typeid:'',
				list:[],
				devtypes:[]
			};
		},
		methods:{
			update(devid){
				this.$router.push({name:'DeviceEdit',params:{devid:devid}});
			},
			del(devid){
				var url = this.baseUrl+"/baseDevice/delete"
				var data = {devid:devid};
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
				this.$router.push("/DeviceAdd");
			},
			search(){
				var url = this.baseUrl+"/baseDevice/search"
				var data = {devname:this.search_devname,typeid:this.search_typeid};
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
			var url2 = this.baseUrl+"/baseDevtype/list"
			this.$axios.post(url2,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.devtypes = res.data;
			})
		}
		
	}
</script>

<style>

</style>
