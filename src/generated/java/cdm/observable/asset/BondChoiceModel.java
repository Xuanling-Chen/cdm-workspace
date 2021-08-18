package cdm.observable.asset;

import cdm.base.staticdata.asset.common.Bond;
import cdm.base.staticdata.asset.common.ConvertibleBond;
import cdm.observable.asset.meta.BondChoiceModelMeta;
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
 *  Either a bond or convertible bond.
 * @version ${project.version}
 */
@RosettaClass

public interface BondChoiceModel extends RosettaModelObject {
	BondChoiceModel build();
	BondChoiceModel.BondChoiceModelBuilder toBuilder();
	
	/**
	 */
	Bond getBond();
	/**
	 */
	ConvertibleBond getConvertibleBond();
	final static BondChoiceModelMeta metaData = new BondChoiceModelMeta();
	
	@Override
	default RosettaMetaData<? extends BondChoiceModel> metaData() {
		return metaData;
	} 
			
	static BondChoiceModel.BondChoiceModelBuilder builder() {
		return new BondChoiceModel.BondChoiceModelBuilderImpl();
	}
	
	default Class<? extends BondChoiceModel> getType() {
		return BondChoiceModel.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("bond"), processor, Bond.class, getBond());
		processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.class, getConvertibleBond());
	}
	
	
	interface BondChoiceModelBuilder extends BondChoiceModel, RosettaModelObjectBuilder {
		Bond.BondBuilder getOrCreateBond();
		Bond.BondBuilder getBond();
		ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond();
		ConvertibleBond.ConvertibleBondBuilder getConvertibleBond();
		BondChoiceModel.BondChoiceModelBuilder setBond(Bond bond);
		BondChoiceModel.BondChoiceModelBuilder setConvertibleBond(ConvertibleBond convertibleBond);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("bond"), processor, Bond.BondBuilder.class, getBond());
			processRosetta(path.newSubPath("convertibleBond"), processor, ConvertibleBond.ConvertibleBondBuilder.class, getConvertibleBond());
		}
		
	}
	
	//BondChoiceModel.BondChoiceModelImpl
	class BondChoiceModelImpl implements BondChoiceModel {
		private final Bond bond;
		private final ConvertibleBond convertibleBond;
		
		protected BondChoiceModelImpl(BondChoiceModel.BondChoiceModelBuilder builder) {
			this.bond = ofNullable(builder.getBond()).map(f->f.build()).orElse(null);
			this.convertibleBond = ofNullable(builder.getConvertibleBond()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Bond getBond() {
			return bond;
		}
		
		@Override
		public ConvertibleBond getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public BondChoiceModel build() {
			return this;
		}
		
		@Override
		public BondChoiceModel.BondChoiceModelBuilder toBuilder() {
			BondChoiceModel.BondChoiceModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(BondChoiceModel.BondChoiceModelBuilder builder) {
			ofNullable(getBond()).ifPresent(builder::setBond);
			ofNullable(getConvertibleBond()).ifPresent(builder::setConvertibleBond);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondChoiceModel _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondChoiceModel {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond +
			'}';
		}
	}
	
	//BondChoiceModel.BondChoiceModelBuilderImpl
	class BondChoiceModelBuilderImpl implements BondChoiceModel.BondChoiceModelBuilder {
	
		protected Bond.BondBuilder bond;
		protected ConvertibleBond.ConvertibleBondBuilder convertibleBond;
	
		public BondChoiceModelBuilderImpl() {
		}
	
		@Override
		public Bond.BondBuilder getBond() {
			return bond;
		}
		
		@Override
		public Bond.BondBuilder getOrCreateBond() {
			Bond.BondBuilder result;
			if (bond!=null) {
				result = bond;
			}
			else {
				result = bond = Bond.builder();
			}
			
			return result;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder getConvertibleBond() {
			return convertibleBond;
		}
		
		@Override
		public ConvertibleBond.ConvertibleBondBuilder getOrCreateConvertibleBond() {
			ConvertibleBond.ConvertibleBondBuilder result;
			if (convertibleBond!=null) {
				result = convertibleBond;
			}
			else {
				result = convertibleBond = ConvertibleBond.builder();
			}
			
			return result;
		}
		
	
		@Override
		public BondChoiceModel.BondChoiceModelBuilder setBond(Bond bond) {
			this.bond = bond==null?null:bond.toBuilder();
			return this;
		}
		@Override
		public BondChoiceModel.BondChoiceModelBuilder setConvertibleBond(ConvertibleBond convertibleBond) {
			this.convertibleBond = convertibleBond==null?null:convertibleBond.toBuilder();
			return this;
		}
		
		@Override
		public BondChoiceModel build() {
			return new BondChoiceModel.BondChoiceModelImpl(this);
		}
		
		@Override
		public BondChoiceModel.BondChoiceModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondChoiceModel.BondChoiceModelBuilder prune() {
			if (bond!=null && !bond.prune().hasData()) bond = null;
			if (convertibleBond!=null && !convertibleBond.prune().hasData()) convertibleBond = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBond()!=null && getBond().hasData()) return true;
			if (getConvertibleBond()!=null && getConvertibleBond().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public BondChoiceModel.BondChoiceModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			BondChoiceModel.BondChoiceModelBuilder o = (BondChoiceModel.BondChoiceModelBuilder) other;
			
			merger.mergeRosetta(getBond(), o.getBond(), this::setBond);
			merger.mergeRosetta(getConvertibleBond(), o.getConvertibleBond(), this::setConvertibleBond);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			BondChoiceModel _that = getType().cast(o);
		
			if (!Objects.equals(bond, _that.getBond())) return false;
			if (!Objects.equals(convertibleBond, _that.getConvertibleBond())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (bond != null ? bond.hashCode() : 0);
			_result = 31 * _result + (convertibleBond != null ? convertibleBond.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "BondChoiceModelBuilder {" +
				"bond=" + this.bond + ", " +
				"convertibleBond=" + this.convertibleBond +
			'}';
		}
	}
}
