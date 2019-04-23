import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Login from '@/components/home/Login'
import Index from '@/components/home/Index'
import Welcome from '@/components/home/Welcome'
import MainTable from '@/components/home/MainTable'
import CompList from '@/components/baseInfo/CompList'
import CompAdd from '@/components/baseInfo/CompAdd'
import CompEdit from '@/components/baseInfo/CompEdit'
import UserList from '@/components/baseInfo/UserList'
import UserAdd from '@/components/baseInfo/UserAdd'
import UserEdit from '@/components/baseInfo/UserEdit'
import DevtypeList from '@/components/baseInfo/DevtypeList'
import DevtypeAdd from '@/components/baseInfo/DevtypeAdd'
import DevtypeEdit from '@/components/baseInfo/DevtypeEdit'
import DeviceList from '@/components/baseInfo/DeviceList'
import DeviceAdd from '@/components/baseInfo/DeviceAdd'
import DeviceEdit from '@/components/baseInfo/DeviceEdit'
import FlowList from '@/components/baseInfo/FlowList'
import FlowAdd from '@/components/baseInfo/FlowAdd'
import FlowEdit from '@/components/baseInfo/FlowEdit'
import ReportList from '@/components/produce/ReportList'
import ReportAdd from '@/components/produce/ReportAdd'
import ReportEdit from '@/components/produce/ReportEdit'
import RepairList from '@/components/produce/RepairList'
import RepairAdd from '@/components/produce/RepairAdd'
import RepairEdit from '@/components/produce/RepairEdit'
import FaultList from '@/components/produce/FaultList'
import FaultAdd from '@/components/produce/FaultAdd'
import FaultEdit from '@/components/produce/FaultEdit'
import ScoalList from '@/components/energy/ScoalList'
import ScoalAdd from '@/components/energy/ScoalAdd'
import ScoalEdit from '@/components/energy/ScoalEdit'
import Control from '@/components/produce/Control'
import JobList from '@/components/produce/JobList'
import ConsumeList from '@/components/energy/ConsumeList'
import JobAmount from '@/components/report/JobAmount'
import EnergyConsume from '@/components/report/EnergyConsume'


Vue.use(Router)

export default new Router({
  routes: [
    {path: '/Login',name: 'Login',component: Login},
    {
      path: '/',name: 'Index',component: Index,
			children:[
					{path:'/',component:Welcome},
					{path:'CompList',component:CompList,name:'CompList'},
					{path:'CompAdd',component:CompAdd},
					{path:'CompEdit',component:CompEdit,name:'CompEdit'},
					{path:'UserList',component:UserList,name:'UserList'},
					{path:'UserAdd',component:UserAdd},
					{path:'UserEdit',component:UserEdit,name:'UserEdit'},
					{path:'DevtypeList',component:DevtypeList,name:'DevtypeList'},
					{path:'DevtypeAdd',component:DevtypeAdd},
					{path:'DevtypeEdit',component:DevtypeEdit,name:'DevtypeEdit'},
					{path:'DeviceList',component:DeviceList,name:'DeviceList'},
					{path:'DeviceAdd',component:DeviceAdd,name:'DeviceAdd'},
					{path:'DeviceEdit',component:DeviceEdit,name:'DeviceEdit'},
					{path:'FlowList',component:FlowList,name:'FlowList'},
					{path:'FlowAdd',component:FlowAdd,name:'FlowAdd'},
					{path:'FlowEdit',component:FlowEdit,name:'FlowEdit'},
					{path:'ReportList',component:ReportList,name:'ReportList'},
					{path:'ReportAdd',component:ReportAdd,name:'ReportAdd'},
					{path:'ReportEdit',component:ReportEdit,name:'ReportEdit'},
					{path:'RepairList',component:RepairList,name:'RepairList'},
					{path:'RepairAdd',component:RepairAdd,name:'RepairAdd'},
					{path:'RepairEdit',component:RepairEdit,name:'RepairEdit'},
					{path:'FaultList',component:FaultList,name:'FaultList'},
					{path:'FaultAdd',component:FaultAdd,name:'FaultAdd'},
					{path:'FaultEdit',component:FaultEdit,name:'FaultEdit'},
					{path:'ScoalList',component:ScoalList,name:'ScoalList'},
					{path:'ScoalAdd',component:ScoalAdd,name:'ScoalAdd'},
					{path:'ScoalEdit',component:ScoalEdit,name:'ScoalEdit'},
					{path:'Control',component:Control,name:'Control'},
					{path:'JobList',component:JobList,name:'JobList'},
					{path:'ConsumeList',component:ConsumeList,name:'ConsumeList'},
					{path:'JobAmount',component:JobAmount,name:'JobAmount'},
					{path:'EnergyConsume',component:EnergyConsume,name:'EnergyConsume'},
					{path:'MainTable',component:MainTable}
			]
    }
		
		
  ]
})
