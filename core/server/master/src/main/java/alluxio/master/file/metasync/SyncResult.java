/*
 * The Alluxio Open Foundation licenses this work under the Apache License, version 2.0
 * (the "License"). You may not use this work except in compliance with the License, which is
 * available at www.apache.org/licenses/LICENSE-2.0
 *
 * This software is distributed on an "AS IS" basis, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied, as more fully set forth in the License.
 *
 * See the NOTICE file distributed with this work for information regarding copyright ownership.
 */

package alluxio.master.file.metasync;

import java.util.Map;
import javax.annotation.Nullable;

/**
 * Metadata sync results.
 */
public class SyncResult {
  public SyncResult(boolean success, long syncDuration,
                    Map<SyncOperation, Long> successOperationCount,
                    Map<SyncOperation, Long> failedOperationCount,
                    @Nullable SyncFailReason failReason) {
    mSuccess = success;
    mSyncDuration = syncDuration;
    mSuccessOperationCount = successOperationCount;
    mFailedOperationCount = failedOperationCount;
    mSyncFailReason = failReason;
  }

  private final boolean mSuccess;
  private final long mSyncDuration;

  private final Map<SyncOperation, Long> mSuccessOperationCount;
  private final Map<SyncOperation, Long> mFailedOperationCount;

  private @Nullable final SyncFailReason mSyncFailReason;

  public long getSyncDuration() {
    return mSyncDuration;
  }

  public Map<SyncOperation, Long> getSuccessOperationCount() {
    return mSuccessOperationCount;
  }

  public Map<SyncOperation, Long> getFailedOperationCount() {
    return mFailedOperationCount;
  }

  public @Nullable SyncFailReason getFailReason() {
    return mSyncFailReason;
  }

  /**
   * @return if the metadata sync succeeded
   */
  public boolean getSuccess() {
    return mSuccess;
  }
}
