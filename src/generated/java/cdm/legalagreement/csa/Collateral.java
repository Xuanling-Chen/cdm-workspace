package cdm.legalagreement.csa;

import cdm.legalagreement.csa.meta.CollateralMeta;
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
 * A type for defining the obligations of the counterparty subject to credit support requirements.
 * @version ${project.version}
 */
@RosettaClass

public interface Collateral extends RosettaModelObject {
	Collateral build();
	Collateral.CollateralBuilder toBuilder();
	
	/**
	 * Independent Amount is an amount that usually less creditworthy counterparties are asked to provide. It can either be a fixed amount or a percentage of the Transaction&#39;s value. The Independent Amount can be: (i) transferred before any trading between the parties occurs (as a deposit at a third party&#39;s account or with the counterparty) or (ii) callable after trading has occurred (typically because a downgrade has occurred). In situation (i), the Independent Amount is not included in the calculation of Exposure, but in situation (ii), it is included in the calculation of Exposure. Thus, for situation (ii), the Independent Amount may be transferred along with any collateral call. Independent Amount is a defined term in the ISDA Credit Support Annex. (&#39;with respect to a party, the amount specified as such for that party in Paragraph 13; if no amount is specified, zero&#39;).
	 */
	IndependentAmount getIndependentAmount();
	final static CollateralMeta metaData = new CollateralMeta();
	
	@Override
	default RosettaMetaData<? extends Collateral> metaData() {
		return metaData;
	} 
			
	static Collateral.CollateralBuilder builder() {
		return new Collateral.CollateralBuilderImpl();
	}
	
	default Class<? extends Collateral> getType() {
		return Collateral.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.class, getIndependentAmount());
	}
	
	
	interface CollateralBuilder extends Collateral, RosettaModelObjectBuilder {
		IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount();
		IndependentAmount.IndependentAmountBuilder getIndependentAmount();
		Collateral.CollateralBuilder setIndependentAmount(IndependentAmount independentAmount);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("independentAmount"), processor, IndependentAmount.IndependentAmountBuilder.class, getIndependentAmount());
		}
		
	}
	
	//Collateral.CollateralImpl
	class CollateralImpl implements Collateral {
		private final IndependentAmount independentAmount;
		
		protected CollateralImpl(Collateral.CollateralBuilder builder) {
			this.independentAmount = ofNullable(builder.getIndependentAmount()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public IndependentAmount getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public Collateral build() {
			return this;
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			Collateral.CollateralBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Collateral.CollateralBuilder builder) {
			ofNullable(getIndependentAmount()).ifPresent(builder::setIndependentAmount);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!Objects.equals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Collateral {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}
	
	//Collateral.CollateralBuilderImpl
	class CollateralBuilderImpl implements Collateral.CollateralBuilder {
	
		protected IndependentAmount.IndependentAmountBuilder independentAmount;
	
		public CollateralBuilderImpl() {
		}
	
		@Override
		public IndependentAmount.IndependentAmountBuilder getIndependentAmount() {
			return independentAmount;
		}
		
		@Override
		public IndependentAmount.IndependentAmountBuilder getOrCreateIndependentAmount() {
			IndependentAmount.IndependentAmountBuilder result;
			if (independentAmount!=null) {
				result = independentAmount;
			}
			else {
				result = independentAmount = IndependentAmount.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Collateral.CollateralBuilder setIndependentAmount(IndependentAmount independentAmount) {
			this.independentAmount = independentAmount==null?null:independentAmount.toBuilder();
			return this;
		}
		
		@Override
		public Collateral build() {
			return new Collateral.CollateralImpl(this);
		}
		
		@Override
		public Collateral.CollateralBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder prune() {
			if (independentAmount!=null && !independentAmount.prune().hasData()) independentAmount = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getIndependentAmount()!=null && getIndependentAmount().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Collateral.CollateralBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Collateral.CollateralBuilder o = (Collateral.CollateralBuilder) other;
			
			merger.mergeRosetta(getIndependentAmount(), o.getIndependentAmount(), this::setIndependentAmount);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Collateral _that = getType().cast(o);
		
			if (!Objects.equals(independentAmount, _that.getIndependentAmount())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (independentAmount != null ? independentAmount.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CollateralBuilder {" +
				"independentAmount=" + this.independentAmount +
			'}';
		}
	}
}
