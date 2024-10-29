package org.jsp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PERIOD_MASTER {
	 @Id
	    @Column(name = "PERIOD_ID")
	    private Long periodId;

	    @Column(name = "PERIOD_NAME")
	    private String periodName;

	    @Column(name = "FIN_YEAR_ID")
	    private Long finYearId;

		public Long getPeriodId() {
			return periodId;
		}

		public void setPeriodId(Long periodId) {
			this.periodId = periodId;
		}

		public String getPeriodName() {
			return periodName;
		}

		public void setPeriodName(String periodName) {
			this.periodName = periodName;
		}

		public Long getFinYearId() {
			return finYearId;
		}

		public void setFinYearId(Long finYearId) {
			this.finYearId = finYearId;
		}

		@Override
		public String toString() {
			return "PERIOD_MASTER [periodId=" + periodId + ", periodName=" + periodName + ", finYearId=" + finYearId
					+ "]";
		}

	

	
	
}
