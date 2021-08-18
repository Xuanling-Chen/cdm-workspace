package cdm.regulation;

import cdm.regulation.meta.SellrMeta;
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
 * @version ${project.version}
 */
@RosettaClass

public interface Sellr extends RosettaModelObject {
	Sellr build();
	Sellr.SellrBuilder toBuilder();
	
	/**
	 */
	AcctOwnr getAcctOwnr();
	final static SellrMeta metaData = new SellrMeta();
	
	@Override
	default RosettaMetaData<? extends Sellr> metaData() {
		return metaData;
	} 
			
	static Sellr.SellrBuilder builder() {
		return new Sellr.SellrBuilderImpl();
	}
	
	default Class<? extends Sellr> getType() {
		return Sellr.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("acctOwnr"), processor, AcctOwnr.class, getAcctOwnr());
	}
	
	
	interface SellrBuilder extends Sellr, RosettaModelObjectBuilder {
		AcctOwnr.AcctOwnrBuilder getOrCreateAcctOwnr();
		AcctOwnr.AcctOwnrBuilder getAcctOwnr();
		Sellr.SellrBuilder setAcctOwnr(AcctOwnr acctOwnr);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("acctOwnr"), processor, AcctOwnr.AcctOwnrBuilder.class, getAcctOwnr());
		}
		
	}
	
	//Sellr.SellrImpl
	class SellrImpl implements Sellr {
		private final AcctOwnr acctOwnr;
		
		protected SellrImpl(Sellr.SellrBuilder builder) {
			this.acctOwnr = ofNullable(builder.getAcctOwnr()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public AcctOwnr getAcctOwnr() {
			return acctOwnr;
		}
		
		@Override
		public Sellr build() {
			return this;
		}
		
		@Override
		public Sellr.SellrBuilder toBuilder() {
			Sellr.SellrBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(Sellr.SellrBuilder builder) {
			ofNullable(getAcctOwnr()).ifPresent(builder::setAcctOwnr);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sellr _that = getType().cast(o);
		
			if (!Objects.equals(acctOwnr, _that.getAcctOwnr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (acctOwnr != null ? acctOwnr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "Sellr {" +
				"acctOwnr=" + this.acctOwnr +
			'}';
		}
	}
	
	//Sellr.SellrBuilderImpl
	class SellrBuilderImpl implements Sellr.SellrBuilder {
	
		protected AcctOwnr.AcctOwnrBuilder acctOwnr;
	
		public SellrBuilderImpl() {
		}
	
		@Override
		public AcctOwnr.AcctOwnrBuilder getAcctOwnr() {
			return acctOwnr;
		}
		
		@Override
		public AcctOwnr.AcctOwnrBuilder getOrCreateAcctOwnr() {
			AcctOwnr.AcctOwnrBuilder result;
			if (acctOwnr!=null) {
				result = acctOwnr;
			}
			else {
				result = acctOwnr = AcctOwnr.builder();
			}
			
			return result;
		}
		
	
		@Override
		public Sellr.SellrBuilder setAcctOwnr(AcctOwnr acctOwnr) {
			this.acctOwnr = acctOwnr==null?null:acctOwnr.toBuilder();
			return this;
		}
		
		@Override
		public Sellr build() {
			return new Sellr.SellrImpl(this);
		}
		
		@Override
		public Sellr.SellrBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sellr.SellrBuilder prune() {
			if (acctOwnr!=null && !acctOwnr.prune().hasData()) acctOwnr = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getAcctOwnr()!=null && getAcctOwnr().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public Sellr.SellrBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			Sellr.SellrBuilder o = (Sellr.SellrBuilder) other;
			
			merger.mergeRosetta(getAcctOwnr(), o.getAcctOwnr(), this::setAcctOwnr);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			Sellr _that = getType().cast(o);
		
			if (!Objects.equals(acctOwnr, _that.getAcctOwnr())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (acctOwnr != null ? acctOwnr.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "SellrBuilder {" +
				"acctOwnr=" + this.acctOwnr +
			'}';
		}
	}
}
