package com.heima.service;

public class Serviceimple implements seviceInter {

	@Override
	public void save() {
		System.out.println("添加联系人");
	}

	@Override
	public void update() {
		System.out.println("更新联系人");

	}

	@Override
	public void find() {
		System.out.println("查找联系人");

	}
	

	@Override
	public void delete() {
		System.out.println("删除联系人");

	}

}
