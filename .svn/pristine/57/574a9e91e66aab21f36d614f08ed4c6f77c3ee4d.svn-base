<template>
	<div style='text-align: center;'>
		<h1>更新人员信息</h1>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入姓名' v-model='cname'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入用户名' v-model='username'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入密码' v-model='password'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入电话' v-model='telno'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入邮箱' v-model='email'></el-input> </el-col>
		  <el-col :span="12"> <el-input style='width:300px;margin-top: 20px;' placeholder='请输入性别' v-model='sex'></el-input> </el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"> 
		    <el-select  placeholder="请选择" style='width:300px;margin-top: 20px;' v-model='compid'>
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
				userid:'',
				cname:'',
				username:'',
				password:'',
				telno:'',
				email:'',
				sex:'',
				compid:'',
				comps:[]
			};
		},
		methods:{
			saveEdit(){
				// 后端网址
				var url = this.baseUrl+"/baseUser/update"
				// 传递给后端的数据
				var data = {cname:this.cname,username:this.username,password:this.password,
					telno:this.telno,email:this.email,sex:this.sex,compid:this.compid,userid:this.userid
				};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					  }
				  }).then(res=>{
					  // res是后端的响应
					  this.$message("更新成功");
					  this.$router.push({path:'/UserList'});
				  })
			},
			cancel(){
				this.$router.go(-1);
			}
		},
		mounted:function(){
			var url = this.baseUrl+"/baseCompany/list"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				this.comps = res.data;
			})
			
			// 获取路由传递的对象
			var userid = this.$route.params.userid;
			var url2 = this.baseUrl+"/baseUser/load"
			var data = {userid:userid};
			this.$axios.post(url2,this.$qs.stringify(data),{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				var obj = res.data;
				this.userid=obj.userid;
				this.cname=obj.cname;
				this.username=obj.username;
				this.password=obj.password;
				this.telno=obj.telno;
				this.email=obj.email;
				this.sex=obj.sex;
				this.compid=obj.compid;
			})
			
			
		}
		
	}
</script>

<style>

</style>
