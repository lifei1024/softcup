<template>
	<div style='text-align: center;'>
		<h1>添加流程信息</h1>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入流程名称' v-model='flowname'></el-input> </el-col>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择斗轮机" style='width:300px;margin-top: 20px;' v-model='dljid'>
				<el-option v-for="item in dljs" :key="item.devid" :label="item.devname" :value="item.devid">
				</el-option>
			  </el-select>
		  </el-col>
		</el-row>
		<el-row>
			<el-col :span="12"> 
			  <el-select  placeholder="请选择装船机" style='width:300px;margin-top: 20px;' v-model='zcjid'>
							<el-option v-for="item in zcjs" :key="item.devid" :label="item.devname" :value="item.devid">
							</el-option>
						  </el-select>
			</el-col>
			<el-col :span="12"> 
			  <el-select  placeholder="请选择皮带机" style='width:300px;margin-top: 20px;' v-model='pdjid'>
							<el-option v-for="item in pdjs" :key="item.devid" :label="item.devname" :value="item.devid">
							</el-option>
						  </el-select>
			</el-col>
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
				flowname:'',
				dljid:'',
				zcjid:'',
				pdjid:'',
				dljs:[],
				zcjs:[],
				pdjs:[]
			};
		},
		methods:{
			saveAdd(){
				// 后端网址
				var url = this.baseUrl+"/baseFlow/insert"
				// 传递给后端的数据
				var data = {flowname:this.flowname,dljid:this.dljid,zcjid:this.zcjid,
					pdjid:this.pdjid
				};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.$message("添加成功");
					  this.$router.push({path:'/FlowList'});
				  })
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			var url = this.baseUrl+"/baseDevice/findDljByCompid"
			var url2 = this.baseUrl+"/baseDevice/findCzjByCompid"
			var url3 = this.baseUrl+"/baseDevice/findPdjByCompid"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.dljs = res.data;
			})
			this.$axios.post(url2,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.zcjs = res.data;
			})
			this.$axios.post(url3,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.pdjs = res.data;
			})
		}
		
	}
</script>

<style>

</style>
