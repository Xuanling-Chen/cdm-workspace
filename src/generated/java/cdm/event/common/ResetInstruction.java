package cdm.event.common;

import cdm.event.common.meta.ResetInstructionMeta;
import cdm.product.template.Payout;
import cdm.product.template.Payout;
import cdm.product.template.metafields.ReferenceWithMetaPayout;
import cdm.product.template.metafields.ReferenceWithMetaPayout.ReferenceWithMetaPayoutBuilder;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.model.lib.records.Date;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the information needed to create a Reset Business Event. 
 * @version ${project.version}
 */
@RosettaClass

public interface ResetInstruction extends RosettaModelObject {
	ResetInstruction build();
	ResetInstruction.ResetInstructionBuilder toBuilder();
	
	/**
	 */
	ReferenceWithMetaPayout getPayout();
	/**
	 * Specifies the &#39;Rate Record Day&#39; for a Fallback rate.  Fallback rate fixing processes typically set the fixing rate in arrears, i.e., the Fallback Rate corresponding to a Rate Record Date is set at the end of the interest accural period.  When this applies, Reset-&gt;resetDate occurs at the end of the interest period, and the Reset-&gt;rateRecordDate occurs near the start of the interest period.  The Reset-&gt;rateRecordDate and Reset-&gt;observations-&gt;observationIdentifier-&gt;observationDate will differ if a Fallback rate is unavailable on the Rate Record Date, and the latest previous available rate is used as the observation.
	 */
	Date getRateRecordDate();
	final static ResetInstructionMeta metaData = new ResetInstructionMeta();
	
	@Override
	default RosettaMetaData<? extends ResetInstruction> metaData() {
		return metaData;
	} 
			
	static ResetInstruction.ResetInstructionBuilder builder() {
		return new ResetInstruction.ResetInstructionBuilderImpl();
	}
	
	default Class<? extends ResetInstruction> getType() {
		return ResetInstruction.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
		
		processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayout.class, getPayout());
	}
	
	
	interface ResetInstructionBuilder extends ResetInstruction, RosettaModelObjectBuilder {
		ReferenceWithMetaPayoutBuilder getOrCreatePayout();
		ReferenceWithMetaPayoutBuilder getPayout();
		ResetInstruction.ResetInstructionBuilder setPayout(ReferenceWithMetaPayout payout);
		ResetInstruction.ResetInstructionBuilder setPayoutValue(Payout payout);
		ResetInstruction.ResetInstructionBuilder setRateRecordDate(Date rateRecordDate);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("rateRecordDate"), Date.class, getRateRecordDate(), this);
			
			processRosetta(path.newSubPath("payout"), processor, ReferenceWithMetaPayoutBuilder.class, getPayout());
		}
		
	}
	
	//ResetInstruction.ResetInstructionImpl
	class ResetInstructionImpl implements ResetInstruction {
		private final ReferenceWithMetaPayout payout;
		private final Date rateRecordDate;
		
		protected ResetInstructionImpl(ResetInstruction.ResetInstructionBuilder builder) {
			this.payout = ofNullable(builder.getPayout()).map(f->f.build()).orElse(null);
			this.rateRecordDate = builder.getRateRecordDate();
		}
		
		@Override
		public ReferenceWithMetaPayout getPayout() {
			return payout;
		}
		
		@Override
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
		@Override
		public ResetInstruction build() {
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder toBuilder() {
			ResetInstruction.ResetInstructionBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(ResetInstruction.ResetInstructionBuilder builder) {
			ofNullable(getPayout()).ifPresent(builder::setPayout);
			ofNullable(getRateRecordDate()).ifPresent(builder::setRateRecordDate);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetInstruction _that = getType().cast(o);
		
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetInstruction {" +
				"payout=" + this.payout + ", " +
				"rateRecordDate=" + this.rateRecordDate +
			'}';
		}
	}
	
	//ResetInstruction.ResetInstructionBuilderImpl
	class ResetInstructionBuilderImpl implements ResetInstruction.ResetInstructionBuilder {
	
		protected ReferenceWithMetaPayoutBuilder payout;
		protected Date rateRecordDate;
	
		public ResetInstructionBuilderImpl() {
		}
	
		@Override
		public ReferenceWithMetaPayoutBuilder getPayout() {
			return payout;
		}
		
		@Override
		public ReferenceWithMetaPayoutBuilder getOrCreatePayout() {
			ReferenceWithMetaPayoutBuilder result;
			if (payout!=null) {
				result = payout;
			}
			else {
				result = payout = ReferenceWithMetaPayout.builder();
			}
			
			return result;
		}
		
		@Override
		public Date getRateRecordDate() {
			return rateRecordDate;
		}
		
	
		@Override
		public ResetInstruction.ResetInstructionBuilder setPayout(ReferenceWithMetaPayout payout) {
			this.payout = payout==null?null:payout.toBuilder();
			return this;
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder setPayoutValue(Payout payout) {
			this.getOrCreatePayout().setValue(payout);
			return this;
		}
		@Override
		public ResetInstruction.ResetInstructionBuilder setRateRecordDate(Date rateRecordDate) {
			this.rateRecordDate = rateRecordDate==null?null:rateRecordDate;
			return this;
		}
		
		@Override
		public ResetInstruction build() {
			return new ResetInstruction.ResetInstructionImpl(this);
		}
		
		@Override
		public ResetInstruction.ResetInstructionBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetInstruction.ResetInstructionBuilder prune() {
			if (payout!=null && !payout.prune().hasData()) payout = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPayout()!=null && getPayout().hasData()) return true;
			if (getRateRecordDate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public ResetInstruction.ResetInstructionBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			ResetInstruction.ResetInstructionBuilder o = (ResetInstruction.ResetInstructionBuilder) other;
			
			merger.mergeRosetta(getPayout(), o.getPayout(), this::setPayout);
			
			merger.mergeBasic(getRateRecordDate(), o.getRateRecordDate(), this::setRateRecordDate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			ResetInstruction _that = getType().cast(o);
		
			if (!Objects.equals(payout, _that.getPayout())) return false;
			if (!Objects.equals(rateRecordDate, _that.getRateRecordDate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (payout != null ? payout.hashCode() : 0);
			_result = 31 * _result + (rateRecordDate != null ? rateRecordDate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "ResetInstructionBuilder {" +
				"payout=" + this.payout + ", " +
				"rateRecordDate=" + this.rateRecordDate +
			'}';
		}
	}
}
