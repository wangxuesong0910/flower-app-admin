<template>
	<view class="wrap" style="padding-bottom: 60px;">
		<view>
			<u-toast ref="uToast" />
		</view>
		<u-tabs :list="list" :is-scroll="false" :current="current" @change="change"></u-tabs>
		<!-- 当前套餐 -->

		<view v-if="current === 0">
			<!-- 添加一级分类 -->
			<u-modal v-model="leftShow" width="80%" title="科属添加" confirm-text="添加" :show-cancel-button="modalClose"
				@confirm="submitLeftForm">
				<u-form :model="leftForm" ref="leftForm">
					<u-form-item label="一级分类:" label-width="130">
						<u-input v-model="leftForm.ascription" placeholder="请输入科属" width="200" type="input" />
					</u-form-item>
				</u-form>
			</u-modal>
			<!-- 添加二级分类 -->
			<u-modal v-model="rightShow" width="80%" title="分类添加" confirm-text="添加" :show-cancel-button="modalClose"
				@confirm="submitRightForm">
				<u-form :model="rightForm" ref="rightForm">
					<u-form-item label="一级分类:" label-width="130">
						<u-input v-model="value" type="select" @click="rightFormSelectOpen1" />
						<u-action-sheet :list="rightFormSelectList" v-model="rightFormShow1"
							@click="rightFormSelectCallback1"></u-action-sheet>
						<!-- <u-input placeholder="请选择一级分类" v-model="list.name" type="select" class="form-field-select" /> -->
					</u-form-item>
					<u-form-item label="二级分类:" label-width="130">
						<u-input placeholder="请输入二级分类" width="200" type="input" v-model="rightForm.varieties" />
					</u-form-item>
				</u-form>
			</u-modal>
			<!-- 添加三级分类 -->
			<u-modal :z-index="100" v-model="centerShow" width="80%" title="分类添加" confirm-text="添加"
				:show-cancel-button="modalClose" :async-close="centerAsyncShow" @confirm="submitCenterForm">
				<u-form :model="centerForm" ref="centerForm" class="apply-form-field">
					<u-gap height="20" bg-color="#f5f5f5"></u-gap>
					<!-- <u-form-item label="一级分类" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item> -->

					<u-form-item label="二级分类" label-width="150" right-icon="arrow-right">

						<u-input v-model="value" placeholder="请选择" type="select" class="form-field-select"
							@click="centerFormSelectOpen1" />
						<u-action-sheet :list="centerFormSelectList" v-model="centerFormShow1"
							@click="centerFormSelectCallback1"></u-action-sheet>
					</u-form-item>
					<!-- <u-gap height="20" bg-color="#f5f5f5"></u-gap>
					<u-form-item label="开始时间" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item>
					<u-form-item label="结束时间" label-width="150" right-icon="arrow-right">
						<u-input placeholder="请选择" type="select" class="form-field-select" />
					</u-form-item> -->
					<u-form-item label="三级分类:" label-width="150">
						<u-input placeholder="请输入" type="input" v-model="centerForm.type" />
					</u-form-item>
					<u-form-item label="颜色:" label-width="150">
						<u-input placeholder="请输入" type="input" v-model="centerForm.color" />
					</u-form-item>
					<u-form-item label="图片" label-width="150">
						<view class="u-demo-block__content">
							<view class="u-page__upload-item">
								<u-upload ref="uUpload" :file-list="fileList1" :header="header" :action="action"
									:auto-upload="autoUpload" name="img" :formData="formData" multiple max-count="1">
								</u-upload>
							</view>
						</view>
					</u-form-item>
				</u-form>
			</u-modal>
			<u-gap height="20" bg-color="#f5f5f5"></u-gap>
			<u-row gutter="6" justify="center">
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="leftOpen" type="primary" shape="square" size="medium"
						:ripple="true" ripple-bg-color="#909399">
						添加一级分类
					</u-button>
				</u-col>
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="rightOpen" type="success" shape="square" size="medium"
						:ripple="true" ripple-bg-color="#909399">
						添加二级分类
					</u-button>
				</u-col>
				<u-col span="4">
					<u-button :custom-style="buttonStyle" @click="centerOpen" type="warning" shape="square"
						size="medium" :ripple="true" ripple-bg-color="#909399">
						添加三级分类
					</u-button>
				</u-col>
			</u-row>

			<u-row gutter="32" class="bottom-box" justify="center">
				<u-col span="10">
					<view>
						<u-button type="primary" shape="circle" @click="navTo('/pages/sys/home/index')">确定</u-button>
					</view>
				</u-col>
			</u-row>
		</view>
		<view v-if="current === 1">
			<!-- <view class="search">
				<u-search v-model="keyWords" @custom="search" @search="search"></u-search>
			</view>-->
			<!--			种类列表界面-->

			<!-- <u-card :title-color="'#40c9c6'" :sub-title="item.createDatetime" :title="item.varieties"
				v-for="(item, index) in titleList" :key="index" @head-click="open(item.id)">

				<view class="" slot="body">
					<u-read-more ref="uReadMore" :toggle="true" open-text="收起" close-text="展开">
						<u-swipe-action :show="swipeShow" :btn-width="btnWidth" :options="options"
							class="u-body-item  u-border-bottom u-col-between u-p-t-0"
							v-for="(item1, index1) in contentList[item.id]" :key="index1">

							<u-row gutter="2">
								<u-col span="4">
									<view class="u-body-item-title u-line-2">{{item1.type}}</view>
								</u-col>

								<u-col span="5">
									<view class="u-body-item-title u-line-2">{{item1.createDatetime}}</view>
								</u-col>
								<u-col span="3">
									<image :src="item1.img"></image>
								</u-col>
							</u-row>
						</u-swipe-action>
					</u-read-more>

				</view>
				<view class="" slot="foot">
					<u-icon name="chat-fill" size="34" color="" label="30评论"></u-icon>
				</view>
			</u-card> -->
			<view class="u-demo-wrap" v-for="(item, index) in titleList" :key="index">
				<view class="u-demo-area" >
					<u-toast ref="uToast"></u-toast>
					<u-swipe-action
						bg-color="rgb(250, 250, 250)"
						@click="click"
						v-for="(item1, index1) in contentList[item.id]" 
						:index="index1"
						:key="index1"
						:show="swipeShow"
						:btn-width="btnWidth"
						:options="options"
					>
						<view class="item u-border-bottom" >
							<image mode="aspectFill" :src="item1.img" />
							<!-- 此层wrap在此为必写的，否则可能会出现标题定位错误 -->
							<view class="title-wrap">
								<text class="title u-line-2">{{ item1.type }}</text>
							</view>
							<view class="title-wrap">
								<text class="title u-line-2">{{ item1.createDatetime }}</text>
							</view>
						</view>
					</u-swipe-action>
				</view>
			</view>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				swipeShow: false,
				btnWidth: 180,
				options: [{
						text: '修改',
						style: {
							backgroundColor: '#18b566'
						}
					},
					{
						text: '删除',
						style: {
							backgroundColor: '#dd524d'
						}
					}
				],
				fileList1: [],
				buttonStyle: {
					width: '130rpx',
					alignItem: 'center',
					display: 'flex'
				},
				value: '',
				centerFormValue: '',
				modalClose: true,
				leftShow: false,
				rightShow: false,
				centerShow: false,
				centerAsyncShow: true,
				//自动上传设置为false
				autoUpload: false,
				action: '/erp/core/detailImgUpload',
				header: {
					'Authorization': this.$store.state.vuex_token,
				},
				//三级分类图片名

				formData: {
					fileName: "detailImg"
				},
				list: [{
					name: '添加品种'
				}, {
					name: '品种列表',
				}],
				m2mSimflowList: [],
				m2mOrderFlowList: [],
				current: 0,
				status: 'loadmore',
				iconType: 'circle',
				isDot: false,
				loadText: {
					loadmore: '点击加载更多',
					loading: '正在加载...',
					nomore: '没有更多了'
				},

				keyWords: '',
				form: {},
				titleList: [],
				//二级分类数组
				varietiesList: {},
				contentList: {},
				// 查询参数
				queryParams: {
					pageNum: 1,
					pageSize: 10,
					type: null,
					color: null,
					ascriptionId: null,
					varietiesId: null,
					creator: null,
					createDatetime: null,
					modifyDatetime: null
				},
				clickIndex: 0,
				// 一级分类表单参数
				leftForm: {},
				// 二级分类表单参数
				rightForm: {},
				// 二级分类表单中：一级分类下拉框;下拉列表值
				rightFormShow1: false,
				rightFormSelectList: [],
				// 三级分类表单参数
				centerForm: {},
				centerFormShow1: false,
				centerFormSelectList: [],
				typeList: {},
				detailImg: {
					fileName: 'detailImg',
					img: ''
				},
			}
		},

		onLoad() {
			this.getList();
			this.action = this.vuex_config.baseUrl + this.action;
		},
		created() {},
		computed: {

		},
		methods: {
			click(index, index1) {
				if(index1 == 1) {
					console.log("========>"+index);
					this.$u.toast(`删除了第${index}个cell`);
				} else {
					this.contentList[index].show = false;
					this.$u.toast(`收藏成功`);
				}
			},
			// 删除图片
			deletePic() {

				this.$refs.uUpload.clear();
			},
			// 新增图片
			async afterRead(event) {
				this.$refs.uUpload.upload();
			},

			// 查询二级列表
			getList() {
				// console.log("----->"+JSON.stringify(this.vuex_config.baseUrl))
				this.$u.api.repository.titleListData({}).then(res => {
					this.titleList = res.rows;
					for (let i = 0; i < this.titleList.length; i++) {
						this.queryParams.varietiesId = this.titleList[i].id;
						this.getContentList(this.queryParams);
					}

				});


			},
			//获取三级列表
			getContentList(queryParams) {
				let vid = queryParams.varietiesId;
				this.$u.api.repository.contentListData(
					queryParams
				).then(res => {
					// this.contentList = res.rows;
					let conList = [];
					conList = res.rows;
					// let listdetail = {'id':queryParams.varietiesId,'conList':conList};
					this.contentList[vid] = conList;

					this.$forceUpdate();
				});
			},

			change(index) {
				this.current = index;
			},

			navTo(url) {
				uni.navigateTo({
					url: url
				});
			},
			leftOpen() {
				this.leftShow = true;
			},
			rightOpen() {
				this.rightShow = true;
				this.$u.api.repository.ascriptionList({}).then(res => {
					this.rightFormSelectList = [];
					for (var i = 0; i < res.rows.length; i++) {
						this.varietiesList[res.rows[i].ascription] = res.rows[i].id;
						this.rightFormSelectList.push({
							text: res.rows[i].ascription
						})
					}
				})
			},
			centerOpen() {

				this.centerShow = true;
				//查二级分类对应的一级分类，自动填写一级分类


				this.$u.api.repository.varietiesList({}).then(res => {

					this.centerFormSelectList = [];

					for (var i = 0; i < res.rows.length; i++) {

						this.typeList[res.rows[i].varieties] = res.rows[i].id;

						this.centerFormSelectList.push({
							text: res.rows[i].varieties
						})

					}

				})

			},
			rightFormSelectOpen1() {
				this.rightFormShow1 = true;
			},
			centerFormSelectOpen1() {
				this.centerFormShow1 = true;
			},

			// 点击actionSheet回调
			rightFormSelectCallback1(index) {
				this.value = this.rightFormSelectList[index].text;
			},
			// 点击actionSheet回调
			centerFormSelectCallback1(index) {
				this.value = this.centerFormSelectList[index].text;
			},
			//一级分类表单提交
			submitLeftForm() {
				this.$u.api.repository.submitLeftForm(JSON.stringify(this.leftForm)).then(res => {
					if (res.code != 200) {
						this.$refs.uToast.show({
							title: '添加失败',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "center",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)


					} else {
						// 如果没有错误，也要执行回调
						this.$refs.uToast.show({
							title: '添加成功',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "success",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)
					}
				});
			},
			// 二级分类表单提交
			submitRightForm() {
				this.rightForm.ascriptionId = this.varietiesList[this.value];
				this.$u.api.repository.submitRightForm(JSON.stringify(this.rightForm)).then(res => {
					if (res.code != 200) {
						this.$refs.uToast.show({
							title: '添加失败',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "center",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)


					} else {
						// 如果没有错误，也要执行回调
						this.$refs.uToast.show({
							title: '添加成功',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "success",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)
					}
				});
			},
			// 三级分类表单提交
			submitCenterForm() {
				this.centerForm.varietiesId = this.typeList[this.value];
				this.$refs.uUpload.upload();
				this.$u.api.repository.submitCenterForm(JSON.stringify(this.centerForm)).then(res => {
					// 如果验证出错，需要抛出new Error('错误提示信息')
					if (res.code != 200) {
						this.$refs.uToast.show({
							title: '添加失败',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "center",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)


					} else {
						// 如果没有错误，也要执行回调
						this.$refs.uToast.show({
							title: '添加成功',
							// 如果不传此type参数，默认为default，也可以手动写上 type: 'default'
							type: 'error',
							// 如果不需要图标，请设置为false
							// icon: false
							position: "success",
						});
						setTimeout(() => {
							this.centerShow = false;
						}, 1000)
					}
				});

			}
		}
	}
</script>
<style lang="scss" scoped>
	@import '../index.scss';

	page {
		background-color: #f5f5f5;
	}
.item {
	display: flex;
	padding: 20rpx;
}

image {
	width: 120rpx;
	flex: 0 0 120rpx;
	height: 120rpx;
	margin-right: 20rpx;
	border-radius: 12rpx;
}

.title {
	text-align: left;
	font-size: 28rpx;
	color: $u-content-color;
	margin-top: 35px;
	margin-left: 50px;
}
	.u-card-wrap {
		background-color: $u-bg-color;
		padding: 1px;
	}

	.u-body-item {
		font-size: 32rpx;
		color: #333;
		padding: 20rpx 10rpx;
	}

	.u-body-item image {
		width: 100rpx;
		flex: 0 0 100rpx;
		height: 100rpx;
		border-radius: 8rpx;
		margin-left: 12rpx;
	}

	.wrap .search {
		background: #ffffff;
	}

	.apply-text {
		font-size: 28rpx;
		color: #333333;

		span {
			color: #999999;
		}
	}

	.user-images {
		width: 28px;
		height: 28px;
		margin-right: 8px;
	}

	.apply-list-foot {
		font-size: 28rpx;
	}

	.personnel-list {
		display: flex;
		align-items: center;
		flex-wrap: wrap;

		.personnel-user {
			position: relative;
			margin: 5px 9px 0;
		}

		.user-images {
			width: 48px;
			height: 48px;
			margin-right: 0;

		}

		.iconfont {
			position: absolute;
			top: -12px;
			right: -5px;
			color: #FE0100;
		}
	}
</style>
