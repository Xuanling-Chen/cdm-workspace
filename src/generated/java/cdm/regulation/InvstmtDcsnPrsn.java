package cdm.regulation;

import cdm.regulation.meta.InvstmtDcsnPrsnMeta;
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

public interface InvstmtDcsnPrsn extends RosettaModelObject {
	InvstmtDcsnPrsn build();
	InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder toBuilder();
	
	/**
	 */
	Prsn getPrsn();
	final static InvstmtDcsnPrsnMeta metaData = new InvstmtDcsnPrsnMeta();
	
	@Override
	default RosettaMetaData<? extends InvstmtDcsnPrsn> metaData() {
		return metaData;
	} 
			
	static InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder builder() {
		return new InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilderImpl();
	}
	
	default Class<? extends InvstmtDcsnPrsn> getType() {
		return InvstmtDcsnPrsn.class;
	}
	@Override
	default void process(RosettaPath path, Processor processor) {
		
		processRosetta(path.newSubPath("prsn"), processor, Prsn.class, getPrsn());
	}
	
	
	interface InvstmtDcsnPrsnBuilder extends InvstmtDcsnPrsn, RosettaModelObjectBuilder {
		Prsn.PrsnBuilder getOrCreatePrsn();
		Prsn.PrsnBuilder getPrsn();
		InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder setPrsn(Prsn prsn);
		
		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			
			
			processRosetta(path.newSubPath("prsn"), processor, Prsn.PrsnBuilder.class, getPrsn());
		}
		
	}
	
	//InvstmtDcsnPrsn.InvstmtDcsnPrsnImpl
	class InvstmtDcsnPrsnImpl implements InvstmtDcsnPrsn {
		private final Prsn prsn;
		
		protected InvstmtDcsnPrsnImpl(InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder builder) {
			this.prsn = ofNullable(builder.getPrsn()).map(f->f.build()).orElse(null);
		}
		
		@Override
		public Prsn getPrsn() {
			return prsn;
		}
		
		@Override
		public InvstmtDcsnPrsn build() {
			return this;
		}
		
		@Override
		public InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder toBuilder() {
			InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder builder) {
			ofNullable(getPrsn()).ifPresent(builder::setPrsn);
		}
		
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InvstmtDcsnPrsn _that = getType().cast(o);
		
			if (!Objects.equals(prsn, _that.getPrsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prsn != null ? prsn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InvstmtDcsnPrsn {" +
				"prsn=" + this.prsn +
			'}';
		}
	}
	
	//InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilderImpl
	class InvstmtDcsnPrsnBuilderImpl implements InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder {
	
		protected Prsn.PrsnBuilder prsn;
	
		public InvstmtDcsnPrsnBuilderImpl() {
		}
	
		@Override
		public Prsn.PrsnBuilder getPrsn() {
			return prsn;
		}
		
		@Override
		public Prsn.PrsnBuilder getOrCreatePrsn() {
			Prsn.PrsnBuilder result;
			if (prsn!=null) {
				result = prsn;
			}
			else {
				result = prsn = Prsn.builder();
			}
			
			return result;
		}
		
	
		@Override
		public InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder setPrsn(Prsn prsn) {
			this.prsn = prsn==null?null:prsn.toBuilder();
			return this;
		}
		
		@Override
		public InvstmtDcsnPrsn build() {
			return new InvstmtDcsnPrsn.InvstmtDcsnPrsnImpl(this);
		}
		
		@Override
		public InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder prune() {
			if (prsn!=null && !prsn.prune().hasData()) prsn = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPrsn()!=null && getPrsn().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder o = (InvstmtDcsnPrsn.InvstmtDcsnPrsnBuilder) other;
			
			merger.mergeRosetta(getPrsn(), o.getPrsn(), this::setPrsn);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InvstmtDcsnPrsn _that = getType().cast(o);
		
			if (!Objects.equals(prsn, _that.getPrsn())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (prsn != null ? prsn.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InvstmtDcsnPrsnBuilder {" +
				"prsn=" + this.prsn +
			'}';
		}
	}
}
