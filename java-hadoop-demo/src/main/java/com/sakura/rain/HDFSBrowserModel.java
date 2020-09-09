package com.sakura.rain;


/**
 * hdfs文件实体
 * @author zhangjk
 */
public class HDFSBrowserModel {

	//名称
	private String fileName;
	//大小
	private String len;
	//用户
	private String owner;
	//组
	private String group;
	//权限
	private String permission;
	//日期
	private String modificationTime;
	//判断是否为文件夹 1是 0否
	private String isDir;
	//当前路径的上一路径
	private String fromPath;
	//当前目录
	private String currentPath;
	//当前路径的下一路径
	private String toPath;


	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getLen() {
		return len;
	}
	public void setLen(String len) {
		this.len = len;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getModificationTime() {
		return modificationTime;
	}
	public void setModificationTime(String modificationTime) {
		this.modificationTime = modificationTime;
	}
	public String getIsDir() {
		return isDir;
	}
	public void setIsDir(String isDir) {
		this.isDir = isDir;
	}
	public String getFromPath() {
		return fromPath;
	}
	public void setFromPath(String fromPath) {
		this.fromPath = fromPath;
	}
	public String getCurrentPath() {
		return currentPath;
	}
	public void setCurrentPath(String currentPath) {
		this.currentPath = currentPath;
	}
	public String getToPath() {
		return toPath;
	}
	public void setToPath(String toPath) {
		this.toPath = toPath;
	}
}
