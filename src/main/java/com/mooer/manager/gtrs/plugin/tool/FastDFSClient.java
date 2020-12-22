package com.mooer.manager.gtrs.plugin.tool;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FastDFSClient {

	private TrackerClient trackerClient = null;
	private TrackerServer trackerServer = null;
	private StorageServer storageServer = null;
	private StorageClient1 storageClient = null;

	public static UtilProp utilProp;

	@Autowired
	public void init(UtilProp utilProp) {
		FastDFSClient.utilProp = utilProp;
	}

	public FastDFSClient() throws Exception {
	}
	
	public static FastDFSClient build() throws Exception {
		File confFile = File.createTempFile("fastdfs", ".conf");
		PrintWriter confWriter = new PrintWriter(new FileWriter(confFile));
		confWriter.println("tracker_server=" + utilProp.getTrackerServer());
		confWriter.close();
		ClientGlobal.init(confFile.getAbsolutePath());
		confFile.delete();
		FastDFSClient fastDFSClient = new FastDFSClient();
		fastDFSClient.trackerClient = new TrackerClient();
		fastDFSClient.trackerServer = fastDFSClient.trackerClient.getConnection();
		fastDFSClient.storageServer = fastDFSClient.trackerClient.getStoreStorage(fastDFSClient.trackerServer);
		fastDFSClient.storageClient = new StorageClient1(fastDFSClient.trackerServer, fastDFSClient.storageServer);
		return fastDFSClient;
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileName 文件全路径
	 * @param extName  文件扩展名，不包含（.）
	 * @param metas    文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(String fileName, String extName, NameValuePair[] metas) throws Exception {
		try {
			String result = storageClient.upload_file1(fileName, extName, metas);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭服务，释放资源
				if (null != storageServer) {
					storageServer.close();
				}
				if (null != trackerServer) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String uploadFile(String fileName) throws Exception {
		return uploadFile(fileName, null, null);
	}

	public String uploadFile(String fileName, String extName) throws Exception {
		return uploadFile(fileName, extName, null);
	}

	/**
	 * 上传文件方法
	 * <p>
	 * Title: uploadFile
	 * </p>
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param fileContent 文件的内容，字节数组
	 * @param extName     文件扩展名
	 * @param metas       文件扩展信息
	 * @return
	 * @throws Exception
	 */
	public String uploadFile(byte[] fileContent, String extName, NameValuePair[] metas) throws Exception {
		try {
			String result = storageClient.upload_file1(fileContent, extName, metas);
			return result;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭服务，释放资源
				if (null != storageServer) {
					storageServer.close();
				}
				if (null != trackerServer) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public String uploadFile(byte[] fileContent) throws Exception {
		return uploadFile(fileContent, null, null);
	}

	public String uploadFile(byte[] fileContent, String extName) throws Exception {
		return uploadFile(fileContent, extName, null);
	}

	public String uploadFile(MultipartFile uploadFile){
		String url = null;
		String originalFilename = null;
		String extName = null;
		// 上传到图片服务器
		try {
			if (uploadFile != null) {
				originalFilename = uploadFile.getOriginalFilename();// 接收上传的文件
				extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);// 取扩展名
				url = this.uploadFile(uploadFile.getBytes(), extName);
			}
		} catch (Exception e) {
			this.deleteFile(url);
		} finally {
			try {
				// 关闭服务，释放资源
				if (null != storageServer) {
					storageServer.close();
				}
				if (null != trackerServer) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return url;
	}

	/**
	 * 删除
	 * 
	 * @param filePath group1/M00/00/00/wKhkY12dM3OAcQl0AAABSTGZFAM537.txt
	 * @return
	 */
	public int deleteFile(String filePath) {
		if(StringUtils.isEmpty(filePath)) {
			return -1;
		}
		try {
			System.err.println("delete:" + filePath);
			// fastdfs删除文件
			return storageClient.delete_file1(filePath);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭服务，释放资源
				if (null != storageServer) {
					storageServer.close();
				}
				if (null != trackerServer) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return -1;
	}

	/**
	 * 
	 * @return
	 */
	public byte[] downloadFile(String filePath) {
		try {
			// 根据文件标识下载文件
			byte[] by = this.storageClient.download_file1(filePath);
			// 将数据写入输出流
			return by;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (MyException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭服务，释放资源
				if (null != storageServer) {
					storageServer.close();
				}
				if (null != trackerServer) {
					trackerServer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
