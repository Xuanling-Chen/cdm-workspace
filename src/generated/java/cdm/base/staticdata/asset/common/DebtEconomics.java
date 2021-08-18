package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.meta.DebtEconomicsMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Specifies selected economics of a debt instrument.
 * @version ${project.version}
 */
@RosettaClass

public interface DebtEconomics extends RosettaModelObject {
	DebtEconomics build();
	DebtEconomics.DebtEconomicsBuilder toBuilder();
	
	/**
	 * Specifies the general rule for periodic interest rate payment.
	 */
	DebtInterestEnum getDebtInterest();
	/**
	 * Specifies the general rule for repayment of principal.
	 */
	DebtPrincipalEnum getDebtPrincipal();
	/**
	 * Specifies the order of repayment in the event of a sale or bankruptcy of the issuer or a related party (eg guarantor).
	 */
	DebtSeniorityEnum getDebtSeniority();
	final static DebtEconomicsMeta metaData = new DebtEconomicsMeta();
	
	@Override
	default RosettaMetaData<? extends DebtEconomics> metaData() {
		return metaData;
	} 
			
	static DebtEconomics.DebtEconomicsBuilder builder() {
		return new DebtEconomics.DebtEconomicsBuilderImpl();
	}
	
	default Class<? extends DebtEconomics> getType() {
		return DebtEconomics.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("debtInterest"), DebtInterestEnum.class, getDebtInterest(), this);
		processor.processBasic(path.newSubPath("debtPrincipal"), DebtPrincipalEnum.class, getDebtPrincipal(), this);
		processor.processBasic(path.newSubPath("debtSeniority"), DebtSeniorityEnum.class, getDebtSeniority(), this);
		
	}
	
	
	interface DebtEconomicsBuilder extends DebtEconomics, RosettaModelObjectBuilder {
		DebtEconomics.DebtEconomicsBuilder setDebtInterest(DebtInterestEnum debtInterest);
		DebtEconomics.DebtEconomicsBuilder setDebtPrincipal(DebtPrincipalEnum debtPrincipal);
		DebtEconomics.DebtEconomicsBuilder setDebtSeniority(DebtSeniorityEnum debtSeniority);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			processor.processBasic(path.newSubPath("debtInterest"), DebtInterestEnum.class, getDebtInterest(), this);
			processor.processBasic(path.newSubPath("debtPrincipal"), DebtPrincipalEnum.class, getDebtPrincipal(), this);
			processor.processBasic(path.newSubPath("debtSeniority"), DebtSeniorityEnum.class, getDebtSeniority(), this);
			
		}
		
	}
	
	//DebtEconomics.DebtEconomicsImpl
	class DebtEconomicsImpl implements DebtEconomics {
		private final DebtInterestEnum debtInterest;
		private final DebtPrincipalEnum debtPrincipal;
		private final DebtSeniorityEnum debtSeniority;
		
		protected DebtEconomicsImpl(DebtEconomics.DebtEconomicsBuilder builder) {
			this.debtInterest = builder.getDebtInterest();
			this.debtPrincipal = builder.getDebtPrincipal();
			this.debtSeniority = builder.getDebtSeniority();
		}
		
		@Override
		public DebtInterestEnum getDebtInterest() {
			return debtInterest;
		}
		
		@Override
		public DebtPrincipalEnum getDebtPrincipal() {
			return debtPrincipal;
		}
		
		@Override
		public DebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
		@Override
		public DebtEconomics build() {
			return this;
		}
		
		@Override
		public DebtEconomics.DebtEconomicsBuilder toBuilder() {
			DebtEconomics.DebtEconomicsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(DebtEconomics.DebtEconomicsBuilder builder) {
			ofNullable(getDebtInterest()).ifPresent(builder::setDebtInterest);
			ofNullable(getDebtPrincipal()).ifPresent(builder::setDebtPrincipal);
			ofNullable(getDebtSeniority()).ifPresent(builder::setDebtSeniority);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DebtEconomics _that = getType().cast(o);
		
			if (!Objects.equals(debtInterest, _that.getDebtInterest())) return false;
			if (!Objects.equals(debtPrincipal, _that.getDebtPrincipal())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtInterest != null ? debtInterest.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtPrincipal != null ? debtPrincipal.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DebtEconomics {" +
				"debtInterest=" + this.debtInterest + ", " +
				"debtPrincipal=" + this.debtPrincipal + ", " +
				"debtSeniority=" + this.debtSeniority +
			'}';
		}
	}
	
	//DebtEconomics.DebtEconomicsBuilderImpl
	class DebtEconomicsBuilderImpl implements DebtEconomics.DebtEconomicsBuilder {
	
		protected DebtInterestEnum debtInterest;
		protected DebtPrincipalEnum debtPrincipal;
		protected DebtSeniorityEnum debtSeniority;
	
		public DebtEconomicsBuilderImpl() {
		}
	
		@Override
		public DebtInterestEnum getDebtInterest() {
			return debtInterest;
		}
		
		@Override
		public DebtPrincipalEnum getDebtPrincipal() {
			return debtPrincipal;
		}
		
		@Override
		public DebtSeniorityEnum getDebtSeniority() {
			return debtSeniority;
		}
		
	
		@Override
		public DebtEconomics.DebtEconomicsBuilder setDebtInterest(DebtInterestEnum debtInterest) {
			this.debtInterest = debtInterest==null?null:debtInterest;
			return this;
		}
		@Override
		public DebtEconomics.DebtEconomicsBuilder setDebtPrincipal(DebtPrincipalEnum debtPrincipal) {
			this.debtPrincipal = debtPrincipal==null?null:debtPrincipal;
			return this;
		}
		@Override
		public DebtEconomics.DebtEconomicsBuilder setDebtSeniority(DebtSeniorityEnum debtSeniority) {
			this.debtSeniority = debtSeniority==null?null:debtSeniority;
			return this;
		}
		
		@Override
		public DebtEconomics build() {
			return new DebtEconomics.DebtEconomicsImpl(this);
		}
		
		@Override
		public DebtEconomics.DebtEconomicsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DebtEconomics.DebtEconomicsBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDebtInterest()!=null) return true;
			if (getDebtPrincipal()!=null) return true;
			if (getDebtSeniority()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public DebtEconomics.DebtEconomicsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			DebtEconomics.DebtEconomicsBuilder o = (DebtEconomics.DebtEconomicsBuilder) other;
			
			
			merger.mergeBasic(getDebtInterest(), o.getDebtInterest(), this::setDebtInterest);
			merger.mergeBasic(getDebtPrincipal(), o.getDebtPrincipal(), this::setDebtPrincipal);
			merger.mergeBasic(getDebtSeniority(), o.getDebtSeniority(), this::setDebtSeniority);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			DebtEconomics _that = getType().cast(o);
		
			if (!Objects.equals(debtInterest, _that.getDebtInterest())) return false;
			if (!Objects.equals(debtPrincipal, _that.getDebtPrincipal())) return false;
			if (!Objects.equals(debtSeniority, _that.getDebtSeniority())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (debtInterest != null ? debtInterest.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtPrincipal != null ? debtPrincipal.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (debtSeniority != null ? debtSeniority.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "DebtEconomicsBuilder {" +
				"debtInterest=" + this.debtInterest + ", " +
				"debtPrincipal=" + this.debtPrincipal + ", " +
				"debtSeniority=" + this.debtSeniority +
			'}';
		}
	}
}
