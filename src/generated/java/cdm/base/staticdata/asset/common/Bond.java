package cdm.base.staticdata.asset.common;

import cdm.base.staticdata.asset.common.IdentifiedProduct.IdentifiedProductBuilder;
import cdm.base.staticdata.asset.common.IdentifiedProduct.IdentifiedProductBuilderImpl;
import cdm.base.staticdata.asset.common.IdentifiedProduct.IdentifiedProductImpl;
import cdm.base.staticdata.asset.common.meta.BondMeta;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaClass;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;


/**
 * A class to specify a bond as having a product identifier. As a difference versus the FpML standard, the CDM structure of this class only includes the productIdentifier class, which consists of an identifier, productTaxonomy, and source of the identifier. The reason for this approach is to avoid the potential for conflicting information between the information associated with the contractual product and the reference information maintained by the relevant service provider.
 * @version ${project.version}
 */
@RosettaClass

public interface Bond extends IdentifiedProduct {
	Bond build();
	Bond.BondBuilder toBuilder();
	
	final static BondMeta metaData = new BondMeta();
	
	@Override
	default RosettaMetaData<? extends Bond> metaData() {
		return metaData;
	} 
			
	static Bond.BondBuilder builder() {
		return new Bond.BondBuilderImpl();
	}
	
	default Class<? extends Bond> getType() {
		return Bond.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		cdm.base.staticdata.asset.common.IdentifiedProduct.super.process(path, processor);
		
	}
	
	
	interface BondBuilder extends Bond, IdentifiedProduct.IdentifiedProductBuilder, RosettaModelObjectBuilder {
		Bond.BondBuilder setProductIdentifier(ProductIdentifier productIdentifier);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			IdentifiedProduct.IdentifiedProductBuilder.super.process(path, processor);
			
			
		}
		
	}
	
	//Bond.BondImpl
	class BondImpl extends IdentifiedProduct.IdentifiedProductImpl implements Bond {
		
		protected BondImpl(Bond.BondBuilder builder) {
			super(builder);
		}
		
		@Override
		public Bond build() {
			return this;
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			Bond.BondBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Bond.BondBuilder builder) {
			super.setBuilderFields(builder);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "Bond {" +
			'}' + " " + super.toString();
		}
	}
	
	//Bond.BondBuilderImpl
	class BondBuilderImpl extends IdentifiedProduct.IdentifiedProductBuilderImpl  implements Bond.BondBuilder {
	
	
		public BondBuilderImpl() {
		}
	
	
		@Override
		public Bond.BondBuilder setProductIdentifier(ProductIdentifier productIdentifier) {
			this.productIdentifier = productIdentifier==null?null:productIdentifier.toBuilder();
			return this;
		}
		
		@Override
		public Bond build() {
			return new Bond.BondImpl(this);
		}
		
		@Override
		public Bond.BondBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder prune() {
			super.prune();
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Bond.BondBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			Bond.BondBuilder o = (Bond.BondBuilder) other;
			
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
		
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondBuilder {" +
			'}' + " " + super.toString();
		}
	}
}
