<template>
	<div style='text-align: center;'>
		<h1>更新设备</h1>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='设备名称' v-model='devname'></el-input> </el-col>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择设备类别" style='width:300px;margin-top: 20px;' v-model='typeid'>
				<el-option v-for="item in devtypes" :key="item.typeid" :label="item.typename" :value="item.typeid">
				</el-option>
			  </el-select>
		  </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> 
				<el-date-picker style='width:300px;margin-top: 20px;'  v-model="devdate" type="date" placeholder="投入时间" value-format='yyyy-MM-dd'>
				</el-date-picker>
		  </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='责任人' v-model='devuser'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择所属企业" style='width:300px;margin-top: 20px;' v-model='compid'>
				<el-option v-for="item in comps" :key="item.compid" :label="item.compname" :value="item.compid">
				</el-option>
			  </el-select>
		  </el-col>
		  <el-col :span="12"> <span></span> </el-col>
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
				devname:'',
				typeid:'',
				compid:'',
				devdate:'',
				devuser:'',
				devid:'',
				comps:[],
				devtypes:[]
			};
		},
		methods:{
			saveEdit(){
				// 后端网址
				var url = this.baseUrl+"/baseDevice/update"
				// 传递给后端的数据
				var data = {devname:this.devname,typeid:this.typeid,compid:this.compid,
					devdate:this.devdate,devuser:this.devuser,devid:this.devid
				};
				
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.$message("更新成功");
					  this.$router.push({path:'/DeviceList'});
				  })
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			// 为下拉框赋值
			var url = this.baseUrl+"/baseCompany/list"
			var url2 = this.baseUrl+"/baseDevtype/list"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.comps = res.data;
			})
			this.$axios.post(url2,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.devtypes = res.data;
			})
			
			// 获取路由传递的对象
			var devid = this.$route.params.devid;
			var url3 = this.baseUrl+"/baseDevice/load"
			var data = {devid:devid};
			this.$axios.post(url3,this.$qs.stringify(data),{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				var obj = res.data;
				this.devname=obj.devname;
				this.typeid=obj.typeid;
				this.compid=obj.compid;
				this.devdate=obj.devdate;
				this.devuser=obj.devuser;
				this.devid=obj.devid;
				
				
			})
			
		}
		
	}
</script>

<style>

</style>
