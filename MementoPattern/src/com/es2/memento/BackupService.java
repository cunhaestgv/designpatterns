package com.es2.memento;

import java.util.ArrayList;

/**
 * 
 * This class allows the creation and storage of Server state snapshots encapsulated in a Memento object
 *
 */
public class BackupService {
	private ArrayList<Memento> serverSnapshots = new ArrayList<Memento>();
	private Server server;
	
	public BackupService(Server server) {
		this.server = server;
	}
	
	/**
	 * Takes a Server snapshot and stores it inside a Memento object 
	 */
	public void takeSnapshot() {
		this.serverSnapshots.add(server.backup());
	}
	
	/**
	 * Restores a previous state in the Server
	 * @param snapshotNumber the snapshot number between 0 and (number of snapshots - 1)
	 * @throws NotExistingSnapshotException thrown when the snapshot doesn't exist
	 */
	public void restoreSnapshot(int snapshotNumber) throws NotExistingSnapshotException {
		if(snapshotNumber<0 || snapshotNumber>this.serverSnapshots.size()-1)
			throw new NotExistingSnapshotException();
		this.server.restore(this.serverSnapshots.get(snapshotNumber));
	}

}
