<template>
	<div style='text-align: center;'>
		<h1>添加故障信息</h1>
		<el-row>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择设备名称" style='width:300px;margin-top: 20px;' v-model='devid'>
		  				<el-option v-for="item in devs" :key="item.devid" :label="item.devname" :value="item.devid">
		  				</el-option>
		  			  </el-select>
		  </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='故障原因' v-model='cause'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='报告人' v-model='faultuser'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='故障时间(分钟)' v-model='faulttime'></el-input> </el-col>
		</el-row>
		
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" > <el-button type='primary' @click='saveAdd'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>

<script>
	export default {
		name:'',
		data() {
			return {
				devid:'',
				cause:'',
				faultuser:'',
				faulttime:'',
				devs:[]
			};
		},
		methods:{
			saveAdd(){
				// 后端网址
				var url = this.baseUrl+"/produceFault/insert"
				// 传递给后端的数据
				var data = {devid:this.devid,cause:this.cause,faultuser:this.faultuser,
					faulttime:this.faulttime
				};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.$message("添加成功");
					  this.$router.push({path:'/FaultList'});
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
		}
		
	}
</script>

<style>

</style>
