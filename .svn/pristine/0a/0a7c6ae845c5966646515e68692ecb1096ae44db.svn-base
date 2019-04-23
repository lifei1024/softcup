<template>
	<div style='text-align: center;'>
		<h1>更新维修信息</h1>
		<el-row>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择设备名称" style='width:300px;margin-top: 20px;' v-model='devid'>
		  				<el-option v-for="item in devs" :key="item.devid" :label="item.devname" :value="item.devid">
		  				</el-option>
		  			  </el-select>
		  </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='维修原因' v-model='cause'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='维修费用' v-model='cost'></el-input> </el-col>
		  <el-col :span="12"> 
			<el-date-picker style='width:300px;margin-top: 20px;'  v-model="repairdate" type="date" placeholder="维修日期" 
				value-format='yyyy-MM-dd' format='yyyy-MM-dd'>
			</el-date-picker>
		  </el-col>
		</el-row>
		
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" > <el-button type='primary' @click='saveEdit'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				repairid:'',
				devid:'',
				cause:'',
				cost:'',
				repairdate:'',
				devs:[]
			};
		},
		methods:{
			saveEdit(){
				// 后端网址
				var url = this.baseUrl+"/produceRepair/update"
				// 传递给后端的数据
				var data = {devid:this.devid,cause:this.cause,cost:this.cost,
					repairdate:this.repairdate,repairid:this.repairid
				};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.$message("更新成功");
					  this.$router.push({path:'/RepairList'});
				  })
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			var url = this.baseUrl+"/baseDevice/list";
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.devs = res.data;
			})
			// 获取路由传递的参数
			var repairid = this.$route.params.repairid;
			var url2 = this.baseUrl+"/produceRepair/load"
			var data = {repairid:repairid};
			this.$axios.post(url2,this.$qs.stringify(data),{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				var obj = res.data;
				this.repairid=obj.repairid;
				this.devid=obj.devid;
				this.cause=obj.cause;
				this.cost=obj.cost;
				this.repairdate=obj.repairdate;
				
			})
		}
		
	}
</script>

<style>

</style>
